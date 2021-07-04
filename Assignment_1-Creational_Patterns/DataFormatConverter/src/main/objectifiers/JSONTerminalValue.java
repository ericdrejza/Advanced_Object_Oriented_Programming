package main.objectifiers;

public class JSONTerminalValue extends JSONComponentComposite {
	String value;

	JSONTerminalValue(){
		value = null;
	}
	
	@Override
	public boolean add(JSONComponentComposite component) {
		return false;
	}

	@Override
	public JSONComponentComposite getChild(int index) {
		return null;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toStringWithIndents(int indents) {
		return "\t".repeat(indents) + value;
	}

}
