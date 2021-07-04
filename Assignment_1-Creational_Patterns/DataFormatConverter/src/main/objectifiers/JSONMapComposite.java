package main.objectifiers;

import java.util.ArrayList;

public class JSONMapComposite extends JSONComponentComposite {
	ArrayList<JSONComponentComposite> components;
	
	JSONMapComposite(){
		components = new ArrayList<JSONComponentComposite>();
	}
	
	@Override
	public boolean add(JSONComponentComposite component) {
		if (JSONKeyComposite.class.isInstance(component)) {
			components.add(component);
			return true;
		}
		else {
			System.out.println("Error: Invalid Component attempted to add to JSONArrayComposite");
		}
		return false;
	}

	@Override
	public JSONComponentComposite getChild(int index) {
		return components.get(index);
	}

	@Override
	public String toStringWithIndents(int indents) {
		String result = "\t".repeat(indents) + "{" + "\n";
		for (int i = 0; i < components.size(); i++) {
			result = result + components.get(i).toStringWithIndents(indents + 1);
			if (i + 1 < components.size()) {
				result = result + ",";
			}
			result = result + "\n";
		}
		result = result + "\t".repeat(indents) + "}";
		
		return result;
	}

}
