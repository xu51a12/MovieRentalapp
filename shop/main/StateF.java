package shop.main;

import shop.ui.UIFormTest;


public enum StateF {
	yearTest,numberTest,stringTest;
	
	public UIFormTest gettest() {
		switch(this) {
		default:
			return null;
		case yearTest:
			return new UIFormTest() {
		        public boolean run(String input) {
			          try {
			            int i = Integer.parseInt(input);
			            return i > 1800 && i < 5000;
			          } catch (NumberFormatException e) {
			            return false;
			          }
			        }
			      };
		case numberTest:
			return new UIFormTest() {
		        public boolean run(String input) {
			          try {
			            Integer.parseInt(input);
			            return true;
			          } catch (NumberFormatException e) {
			            return false;
			          }
			        }
			      };
		case stringTest:
			return new UIFormTest() {
		        public boolean run(String input) {
			          return ! "".equals(input.trim());
			        }
			      };
			
		}
		
	}

}
