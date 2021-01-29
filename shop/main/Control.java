package shop.main;

import shop.ui.FormBuilderI;
import shop.ui.UI;
//import shop.ui.UIMenu;
import shop.ui.UIMenuAction;
import shop.ui.UIMenuForm;
//import shop.ui.UIMenuBuilder;
//import shop.ui.UIMenuFormBuilder;
import shop.ui.UIError;
import shop.ui.UIFactory;
//import shop.ui.UIForm;
import shop.ui.UIFormTest;
//import shop.ui.UIFormBuilder;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Video;
import shop.data.Record;
import shop.command.Command;
import java.util.Iterator;
import java.util.Comparator;

class Control {
	  private static final int EXITED = 0;
	  private static final int EXIT = 1;
	  private static final int START = 2;
	  private static final int NUMSTATES = 10;
	  private UIFactory factory = new UIFactory();
	  private UIMenuForm[] _menus;
	  private int _state;

	  private UIMenuForm _getVideoForm;
	  private UIFormTest _numberTest;
	  private UIFormTest _stringTest;
	    
	  private Inventory _inventory;
	  private UI _ui;
	  
	  Control(Inventory inventory, UI ui) {
	    _inventory = inventory;
	    _ui = ui;

	    _menus = new UIMenuForm[NUMSTATES];
	    _state = START;
	    addSTART(START);
	    addEXIT(EXIT);
		FormBuilderI f = factory.createbuilder();
	    
	    UIFormTest yearTest = StateF.yearTest.gettest();
	    _numberTest = StateF.numberTest.gettest();
	    _stringTest = StateF.stringTest.gettest();
	    f.addf("Title", _stringTest);
	    f.addf("Year", yearTest);
	    f.addf("Director", _stringTest);
	    _getVideoForm = f.toUIForm("Enter Video");
	  }
	  
	  void run() {
	    try {
	      while (_state != EXITED) {
	        _ui.processMenu(_menus[_state]);
	      }
	    } catch (UIError e) {
	      _ui.displayError("UI closed");
	    }
	  }
	  public UI getui() {
		  return _ui;
	  }
	  public Inventory getinv() {
		  return _inventory;
	  }
	  
	  private void addSTART(int stateNum) {
		  FormBuilderI m = factory.createbuilder();
		  FormBuilderI f = factory.createbuilder();
	    
	    m.addm("Default",
         State.DEFAULT.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Add/Remove copies of a video",
	    		State.ADDREMOVE.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Check in a video",State.CHECKIN.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Check out a video",State.CHECKOUT.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Print the inventory",State.PRINTINV.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Clear the inventory",State.CLEARINV.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Undo",State.UNDO.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Redo",State.REDO.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    m.addm("Print top ten all time rentals in order",State.PRINT10.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	          
	    m.addm("Exit",
	      new UIMenuAction() {
	        public void run() {
	          _state = EXIT;
	        }
	      });
	    
	    m.addm("Initialize with bogus contents",State.Initialize.getAction(_ui,_inventory,_getVideoForm,_numberTest,f));
	    
	    _menus[stateNum] = m.toUIMenu("Bob's Video");
	  }
	  private void addEXIT(int stateNum) {
		  FormBuilderI m = factory.createbuilder();
	    
	    m.addm("Default", new UIMenuAction() { public void run() {} });
	    m.addm("Yes",
	      new UIMenuAction() {
	        public void run() {
	          _state = EXITED;
	        }
	      });
	    m.addm("No",
	      new UIMenuAction() {
	        public void run() {
	          _state = START;
	        }
	      });
	    
	    _menus[stateNum] = m.toUIMenu("Are you sure you want to exit?");
	  }
	}