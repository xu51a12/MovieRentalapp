package shop.ui;

/**
 * @see UIFormBuilder
 */
 class UIForm implements UIMenuForm {
  private final String _heading;
  private final Pair<String,UIFormTest>[] _form;


  
  UIForm(String heading, Pair<String,UIFormTest>[] menu) {
    _heading = heading;
    _form = menu;
  }
  public int size() {
    return _form.length;
  }
  public String getHeading() {
    return _heading;
  }
  public String getPrompt(int i) {
    return _form[i].prompt;
  }
  public Pair<String,UIFormTest>[] getarr(){
	  return _form;
  }
  public boolean checkInput(int i, String input) {
    if (null == _form[i])
      return true;
    return _form[i].ui.run(input);
  }
  public void runAction(int i) {
	
	  }

}
