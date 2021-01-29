package shop.ui;

import javax.swing.JOptionPane;
//import java.io.IOException;

 final class PopupUI implements UI {
  public void displayMessage(String message) {
    JOptionPane.showMessageDialog(null,message);
  }

  public void displayError(String message) {
    JOptionPane.showMessageDialog(null,message,"Error",JOptionPane.ERROR_MESSAGE);
  }
public void processMenu(UIMenuForm menu) {
    StringBuilder b = new StringBuilder();
    b.append(menu.getHeading());
    b.append("\n");
    b.append("Enter choice by number:");
    b.append("\n");

    for (int i = 1; i < menu.size(); i++) {
      b.append("  " + i + ". " + menu.getPrompt(i));
      b.append("\n");
    }

    String response = JOptionPane.showInputDialog(b.toString());
    if (response == null) {
      response = "";
    }
    int selection;
    try {
      selection = Integer.parseInt(response, 10);
      if ((selection < 0) || (selection >= menu.size()))
        selection = 0;
    } catch (NumberFormatException e) {
      selection = 0;
    }
    UIFactory factory = new UIFactory();
    UIMenuForm m= factory.create("MENU",menu.getHeading(),menu.getarr());

    m.runAction(selection);
  }

  public String[] processForm(UIMenuForm form) {
    // TODO
	  String[] forms = new String[form.size()];
	  for (int i=0;i<form.size();i++) {
		  String message= JOptionPane.showInputDialog(form.getPrompt(i));
		  forms[i]=message;
	  }
    return forms;
  }
}
