package main.objectifiers;

public abstract class JSONDecorator extends JSONComponentDecorator {
	JSONComponentDecorator component;

	@Override
	public void setComponent(JSONComponentDecorator component) {
		this.component = component;
	}

}
