package main.objectifiers;

public abstract class JSONComponentDecorator {
	String content;
	
	public abstract void setComponent(JSONComponentDecorator component);
	
	public void setContent(String string) {
		this.content = string;
	}
}
