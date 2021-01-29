package shop.ui;

public interface FormBuilderI {
	public UIMenu toUIMenu(String heading);
	public UIForm toUIForm(String heading);
	public void addf(String prompt,UIFormTest test);
	public void addm(String prompt,UIMenuAction action);

}
