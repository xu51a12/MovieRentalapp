package shop.ui;

public interface UI {
  public void processMenu(UIMenuForm _menus);
  public String[] processForm(UIMenuForm form);
  public void displayMessage(String message);
  public void displayError(String message);
}
