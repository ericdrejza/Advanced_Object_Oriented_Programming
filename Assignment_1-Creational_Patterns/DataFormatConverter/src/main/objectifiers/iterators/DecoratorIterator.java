package main.objectifiers.iterators;

import main.objectifiers.JSONComponentDecorator;
import main.objectifiers.JSONLine;
import main.objectifiers.JSONDecorator;
import main.objectifiers.JSONNewLineDecorator;


public class DecoratorIterator extends Iterator<JSONComponentDecorator> {
	JSONComponentDecorator first;
	JSONComponentDecorator component;
	
	public DecoratorIterator(JSONComponentDecorator comp){
		first = comp;
		component = null;
	}
	
	@Override
	public JSONComponentDecorator first() {
		return first;
	}

	@Override
	public JSONComponentDecorator next() {
		JSONComponentDecorator curr = currentItem();
		
		if (curr == null) {
			component = first;
			return currentItem();
		}
		else if (JSONDecorator.class.isInstance(currentItem())) {
			if (((JSONDecorator) curr).getComponent() != null) {
				component = ((JSONDecorator) curr).getComponent();
				return currentItem();
			}
		}
		return null;
	}

	@Override
	public boolean isDone() {
		return !hasNext();
	}
	
	@Override
	public boolean hasNext() {
		JSONComponentDecorator curr = currentItem();
		if (curr == null && first != null) {
			return true;
		}
		else if (JSONDecorator.class.isInstance(currentItem())) {
			if (((JSONDecorator) curr).getComponent() != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public JSONComponentDecorator currentItem() {
		return component;
	}
	
}
