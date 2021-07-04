package main.objectifiers;

public class JSONLine extends JSONComponentDecorator {

	JSONLine(){
		super();
	}
	
	JSONLine(String content){
		super();
		this.content = content;
	}
	
	@Override
	public void setComponent(JSONComponentDecorator component) {};
	
	@Override
	public String toString() {
		return content;
	}
}
