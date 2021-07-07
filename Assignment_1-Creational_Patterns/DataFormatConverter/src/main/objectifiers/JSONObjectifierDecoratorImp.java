package main.objectifiers;

import java.io.File;

import main.objectifiers.iterators.DecoratorIterator;

public class JSONObjectifierDecoratorImp extends JSONObjectifierImp {
	private JSONComponentDecorator component;
	
	JSONObjectifierDecoratorImp(){
		super();
		component = null;
	}
	
	@Override
	public void objectify(File file) {
		String[][] parsedData = parserBuilder.parseData(file);
		StringBuilder[] dataLines = new StringBuilder[parsedData.length];
		
		for (int i = 0; i < parsedData.length; i++) {
			StringBuilder sb = new StringBuilder();
			dataLines[i] = sb;
			for (int j = 0; j < parsedData[i].length; j++) {
				sb.append(parsedData[i][j]);
			}
		}
		
		StringBuilder sb;
		JSONComponentDecorator prevComp = null;
		JSONComponentDecorator currComp = null;
		
		for (int i = 0; i < dataLines.length; i++) {
			sb = dataLines[i];
			prevComp = currComp;
			// if the last StringBuilder
			if (i == 0) {
				currComp = new JSONLine(sb.toString());
			}
			else {
				currComp = new JSONNewLineDecorator(sb.toString());
			}
			
			// Set the previous component's component to the current component
			if (prevComp != null && currComp != null) {
				currComp.setComponent(prevComp);				
			}
		}
		this.component = currComp;
	}

	
	@Override
	public String toString() {
		return component.toString();
	}
	
	public String toStringWithIterator() {
		String result = "";
		DecoratorIterator iter = new DecoratorIterator(component);
		while(iter.hasNext()) {
			iter.next();
			result = iter.currentItem().getContent() + "\n" + result;
		}
		return result;
	}
}
