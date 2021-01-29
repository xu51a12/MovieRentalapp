package shop.ui;

/**
 * @see UIMenuBuilder
 */
class UIMenu implements UIMenuForm {
  private final String _heading;
  private final Pair<String,UIMenuAction>[] _menu;

   

  UIMenu(String heading, Pair<String,UIMenuAction>[] menu) {
    _heading = heading;
    _menu = menu;
  }
  public int size() {
    return _menu.length;
  }
  public String getHeading() {
    return _heading;
  }
  public String getPrompt(int i) {
    return _menu[i].prompt;
  }
  public Pair<String,UIMenuAction>[] getarr(){
	  return _menu;
  }
  public void runAction(int i) {
    _menu[i].ui.run();
  }
  public boolean checkInput(int i, String input) {
	  return true;
  }

}
