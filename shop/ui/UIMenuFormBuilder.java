package shop.ui;

import java.util.ArrayList;
import java.util.List;

 class UIMenuFormBuilder implements FormBuilderI {
  private final List<Pair> _menu = new ArrayList<Pair>();
  public void addf(String prompt, UIFormTest test ) {
	    if (test==null)
	        throw new IllegalArgumentException();
	    
    _menu.add(new Pair<String,UIFormTest>(prompt, test));
  }
  public void addm(String prompt, UIMenuAction action ) {
	    if (action==null)
	        throw new IllegalArgumentException();
  _menu.add(new Pair<String,UIMenuAction>(prompt, action));
}
  public UIForm toUIForm(String heading) {
    if (null == heading)
      throw new IllegalArgumentException();
    if (_menu.size() < 1)
      throw new IllegalStateException();
    Pair<String,UIFormTest>[] array = new Pair[_menu.size()];
    for (int i = 0; i < _menu.size(); i++)
      array[i] = _menu.get(i);
    return new UIForm(heading, array);
  }
  public UIMenu toUIMenu(String heading) {
	    if (null == heading)
	      throw new IllegalArgumentException();
	    if (_menu.size() <= 1)
	      throw new IllegalStateException();
	    Pair<String,UIMenuAction>[] array = new Pair[_menu.size()];
	    for (int i = 0; i < _menu.size(); i++)
	      array[i] = _menu.get(i);
	    return new UIMenu(heading, array);
	  }

}
