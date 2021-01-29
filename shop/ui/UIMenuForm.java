package shop.ui;

public interface UIMenuForm<F,S>{
	public int size();
	public String getHeading();
	public String getPrompt(int i);
	public Pair<F,S>[] getarr();
	public void runAction(int i);
	public boolean checkInput(int i, String input);
	
}
