package main.objectifiers;

public class JSONNewLineDecorator extends JSONDecorator {

	JSONNewLineDecorator(){
		super();
	}
	
	JSONNewLineDecorator(String content){
		super();
		this.content = content;
	}
	
	@Override
	public String toString() {
		return component.toString() + "\n" + content;
	}
}
