package main.objectifiers;

import java.util.ArrayList;

public class JSONKeyComposite extends JSONComponentComposite {
	ArrayList<JSONComponentComposite> components;
	String key;

	JSONKeyComposite(){
		components = new ArrayList<JSONComponentComposite>();
		key = null;
	}
	
	@Override
	public boolean add(JSONComponentComposite component) {
		if (! JSONKeyComposite.class.isInstance(component)) {
			if (components.size() == 1) {
				components.set(0, component);
				return true;
			}
			return components.add(component);
		}
		return false;
	}

	@Override
	public JSONComponentComposite getChild(int index) {
		if (!components.isEmpty()) {
			return components.get(0);			
		}
		return null;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return this.key;
	}

	@Override
	public String toStringWithIndents(int indents) {
		String result = "\t".repeat(indents) + key + " : ";
		if (JSONTerminalValue.class.isInstance(getChild(0))) {
			result = result + getChild(0).toStringWithIndents(0);
		}
		else if (JSONMapComposite.class.isInstance(getChild(0)) || JSONArrayComposite.class.isInstance(getChild(0))) {
			result = result + getChild(0).toStringWithIndents(indents + 1);
		}
		return result;
	}

}
