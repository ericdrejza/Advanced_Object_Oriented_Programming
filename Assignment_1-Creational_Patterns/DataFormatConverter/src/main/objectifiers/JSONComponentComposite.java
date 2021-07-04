package main.objectifiers;

public abstract class JSONComponentComposite {
	public abstract boolean add(JSONComponentComposite component);
	public abstract JSONComponentComposite getChild(int index);
	public abstract String toStringWithIndents(int indents);
	
	@Override
	public String toString() {
		return toStringWithIndents(0);
	}
}
