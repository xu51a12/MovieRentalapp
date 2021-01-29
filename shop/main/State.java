package shop.main;
import shop.ui.UIMenuAction;
import shop.ui.FormBuilderI;
import shop.ui.UI;
import shop.ui.UIFormTest;
import shop.ui.UIMenuForm;

import java.util.Iterator;

import shop.command.Command;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Record;
import shop.data.Video;

public enum State {
	DEFAULT,ADDREMOVE,CHECKIN,CHECKOUT,PRINTINV,CLEARINV,UNDO,REDO,PRINT10,Initialize;
	
	public UIMenuAction getAction(UI _ui, Inventory _inventory, UIMenuForm _getVideoForm,UIFormTest _numberTest,FormBuilderI f) {
		switch(this) {
		case DEFAULT:
			return new UIMenuAction() {
				public void run() {
					_ui.displayError("doh!");
				}
			};
		case ADDREMOVE:
			return new UIMenuAction() {
		        public void run() {
			          String[] result1 = _ui.processForm(_getVideoForm);
			          Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
			          f.addf("Number of copies to add/remove", _numberTest);
			          String[] result2 = _ui.processForm(f.toUIForm(""));
			                                             
			          Command c = Data.newAddCmd(_inventory, v, Integer.parseInt(result2[0]));
			          if (! c.run()) {
			            _ui.displayError("Command failed");
			          }
			        }
			      };
		case CHECKIN:
			return new UIMenuAction() {
		        public void run() {
			        	String[] res = _ui.processForm(_getVideoForm);
			            Video v = Data.newVideo(res[0], Integer.parseInt(res[1]), res[2]);

			            Command c = Data.newInCmd(_inventory, v);
			            if (! c.run()) {
			                _ui.displayError("Command failed");
			              }	
			        }
			      };
		case CHECKOUT:
			return new UIMenuAction() {
		        public void run() {
			        	String[] res = _ui.processForm(_getVideoForm);
			            Video v = Data.newVideo(res[0], Integer.parseInt(res[1]), res[2]);

			            Command c = Data.newOutCmd(_inventory, v);
			            if (! c.run()) {
			                _ui.displayError("Command failed");
			              }
			        }
			      };
		case PRINTINV:
			return new UIMenuAction() {
		        public void run() {
			          _ui.displayMessage(_inventory.toString());
			        }
			      };
		case CLEARINV:
			return 	new UIMenuAction() {
		        public void run() {
			          if (!Data.newClearCmd(_inventory).run()) {
			            _ui.displayError("Command failed");
			          }
			        }
			      };
		case UNDO:
			return new UIMenuAction() {
		        public void run() {
			          if (!Data.newUndoCmd(_inventory).run()) {
			            _ui.displayError("Command failed");
			          }
			        }
			      };
		case REDO:
			return new UIMenuAction() {
		        public void run() {
			          if (!Data.newRedoCmd(_inventory).run()) {
			            _ui.displayError("Command failed");
			          }
			        }
			      };
		case PRINT10:
			return new UIMenuAction() {
		        public void run() {
			        	if (_inventory.size() > 0)
			            {
			                Iterator<Record> it = _inventory.iterator(new java.util.Comparator<Record>()
			                {

			                    public int compare(Record r1, Record r2)
			                    {
			                        return r2.numOut() - r1.numOut();
			                    }
			                });

			                StringBuilder b = new StringBuilder();
			                int counter = 1;
			                b.append("top ten all time rentals in order: \n");
			                while (it.hasNext() && counter < 11)
			                {
			                	Record r = it.next();
			                    b.append(" " + r.video().title() + " [" + r.numOwned() + "]\n");

			                    counter++;
			                }
			                _ui.displayMessage(b.toString());
			            } else
			            {
			                _ui.displayError("Inventory is Empty!");
			            }         
			            
			        }
			      };

		case Initialize:
			return new UIMenuAction() {
		        public void run() {
			          Data.newAddCmd(_inventory, Data.newVideo("a", 2000, "m"), 1).run();
			          Data.newAddCmd(_inventory, Data.newVideo("b", 2000, "m"), 2).run();
			          Data.newAddCmd(_inventory, Data.newVideo("c", 2000, "m"), 3).run();
			          Data.newAddCmd(_inventory, Data.newVideo("d", 2000, "m"), 4).run();
			          Data.newAddCmd(_inventory, Data.newVideo("e", 2000, "m"), 5).run();
			          Data.newAddCmd(_inventory, Data.newVideo("f", 2000, "m"), 6).run();
			          Data.newAddCmd(_inventory, Data.newVideo("g", 2000, "m"), 7).run();
			          Data.newAddCmd(_inventory, Data.newVideo("h", 2000, "m"), 8).run();
			          Data.newAddCmd(_inventory, Data.newVideo("i", 2000, "m"), 9).run();
			          Data.newAddCmd(_inventory, Data.newVideo("j", 2000, "m"), 10).run();
			          Data.newAddCmd(_inventory, Data.newVideo("k", 2000, "m"), 11).run();
			          Data.newAddCmd(_inventory, Data.newVideo("l", 2000, "m"), 12).run();
			          Data.newAddCmd(_inventory, Data.newVideo("m", 2000, "m"), 13).run();
			          Data.newAddCmd(_inventory, Data.newVideo("n", 2000, "m"), 14).run();
			          Data.newAddCmd(_inventory, Data.newVideo("o", 2000, "m"), 15).run();
			          Data.newAddCmd(_inventory, Data.newVideo("p", 2000, "m"), 16).run();
			          Data.newAddCmd(_inventory, Data.newVideo("q", 2000, "m"), 17).run();
			          Data.newAddCmd(_inventory, Data.newVideo("r", 2000, "m"), 18).run();
			          Data.newAddCmd(_inventory, Data.newVideo("s", 2000, "m"), 19).run();
			          Data.newAddCmd(_inventory, Data.newVideo("t", 2000, "m"), 20).run();
			          Data.newAddCmd(_inventory, Data.newVideo("u", 2000, "m"), 21).run();
			          Data.newAddCmd(_inventory, Data.newVideo("v", 2000, "m"), 22).run();
			          Data.newAddCmd(_inventory, Data.newVideo("w", 2000, "m"), 23).run();
			          Data.newAddCmd(_inventory, Data.newVideo("x", 2000, "m"), 24).run();
			          Data.newAddCmd(_inventory, Data.newVideo("y", 2000, "m"), 25).run();
			          Data.newAddCmd(_inventory, Data.newVideo("z", 2000, "m"), 26).run();
			        }
			      };
			      
		default:
			return null;
		}
		
	}



	
}
