package shop.ui;

public class UIFactory {
  public UIFactory() {}
  static private UI _UI;
  //static private UI _UI = new TextUI();
  static public UI ui () {
    return _UI;
  }
  //public UIMenu createmenu (String heading,Pair<String,UIMenuAction>[] menu) {
	  //return new UIMenu(heading, menu);
	  
 // }
 // public UIForm createform (String heading,Pair<String,UIFormTest>[] menu) {
	  //return new UIForm(heading, menu);
 // }
  public UIMenuForm create(String type,String heading,Pair[] menu) {
	  if(type.equalsIgnoreCase("FORM")) {
		  return new UIForm(heading, menu);
	  }
	  else if(type.equalsIgnoreCase("MENU")) {
		  return new UIMenu(heading, menu);
	  }
	  return null;
  }
  public UIMenuFormBuilder createbuilder() {
	  return new UIMenuFormBuilder();
  }
  public UI createUI (String type) {
	  if(type.equalsIgnoreCase("POP")) {
		  return new PopupUI();
	  }
	  else if (type.equalsIgnoreCase("TEXT")) {
		  return new TextUI();
	  }
	  return null;
  }
}
