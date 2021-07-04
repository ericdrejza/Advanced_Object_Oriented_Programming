package main.objectifiers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import main.decoders.JSONParserBuilder;
import main.decoders.ParserBuilder;

public class JSONObjectifierCompositeImp extends JSONObjectifierImp {
	private JSONComponentComposite component;
	
	JSONObjectifierCompositeImp(){
		super();
	}
	
	@Override
	public void objectify(File file) {
		String[][] parsedData = parserBuilder.parseData(file);
		List<String> terms = new ArrayList<String>();
		
		
		for (int i = 0; i < parsedData.length; i++) {
			for (int j = 0; j < parsedData[i].length; j++) {
				String term = parsedData[i][j];
				terms.add(term);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String term : terms) {
			sb.append(term);
		}
		char[] charArray = sb.toString().toCharArray();
		charArray = filterSpacesNotInQuotes(charArray);
		
		sb = new StringBuilder();
		sb.append(charArray);
		
		
		// Apologies for the rest of this code, it feels like it's not
		// organized as well is it could be, but I have to move on
		// to other parts of this assignment and other hw and exam.
		// I'm happy it works though, from what I can tell.
		
		// Implement pushdown automata
		// Queue
		Stack<JSONComponentComposite> stack = new Stack<JSONComponentComposite>();
		JSONComponentComposite currComp = null;
		JSONComponentComposite prevComp = null;
		int index1 = 0;
		int index2 = 0;
		
		for (index2 = 1; index2 < sb.length(); index2++) {
			
			String term = sb.substring(index1, index2);
			
			if (! stack.isEmpty()) {
				currComp = stack.peek();				
			}
			
			if (term.equals(",")) {
				index1 = index2;
				continue;
			}
			
			// Check to see if term is the start of a map ('{') 
			if (term.matches("\\{")
					&& !JSONMapComposite.class.isInstance(currComp)
					&& !JSONTerminalValue.class.isInstance(currComp)) {
				prevComp = currComp;
				currComp = stack.push(new JSONMapComposite());
				if (prevComp != null && currComp != null) {
					prevComp.add(currComp);					
				}
				index1 = index2;
			}
			// Check to see if term is the start of an array ('{')
			else if (term.startsWith("[")) {
				prevComp = currComp;
				currComp = stack.push(new JSONArrayComposite());
				if (prevComp != null && currComp != null) {
					prevComp.add(currComp);
				}
				index1 = index2;
			}
			// Keys 
			else if (term.matches(".*(?<!\\\\)\\\"$")) {
				if (JSONMapComposite.class.isInstance(currComp)) {
					prevComp = currComp;
					currComp = stack.push(new JSONKeyComposite());
					prevComp.add(currComp);
				}
				else if (JSONKeyComposite.class.isInstance(currComp)) {
					// Check to see if this is the entire 
					if (term.matches("^\".*(?<!\\\\)\\\"$")) {
						((JSONKeyComposite) currComp).setKey(term);
						// After a key term will always be a colon, so we can skip it.
						index1 = ++index2;
					}
				}
			}
			// if we're working on a key that's not done
			else if (JSONKeyComposite.class.isInstance(currComp)
					&& ((JSONKeyComposite) currComp).getKey() == null) {
				continue;
			}
			else if ((JSONKeyComposite.class.isInstance(currComp)
					|| JSONArrayComposite.class.isInstance(currComp))
					&& !term.matches("]")) {
				prevComp = currComp;
				currComp = stack.push(new JSONTerminalValue());
				if (prevComp != null && currComp != null) {
					prevComp.add(currComp);
				}
				
			}
			// end of term, pop() and update index1;
			else if ((JSONMapComposite.class.isInstance(currComp) && term.matches(".*}$"))
					|| (JSONArrayComposite.class.isInstance(currComp) && term.matches(".*]$")) 
					|| (JSONTerminalValue.class.isInstance(currComp) 
							&& (term.matches(".*,$") || term.matches(".*]$") || term.matches(".*}$")))
					) {
				
				
				// set value to JSONTerminalValue object
				if (JSONTerminalValue.class.isInstance(currComp)) {
					((JSONTerminalValue) currComp).setValue(term.substring(0, term.length()-1));
				}
				
				// After a any of these terms, there will always be a comma,
				// so we can skip it.
				index1 = index2;
				if (JSONTerminalValue.class.isInstance(currComp)
						&& (term.matches(".*]$") || term.matches(".*}$"))) {
					index1 = --index2; // We want to see the ']' or '}' chars next iteration
				}
				
				if (JSONMapComposite.class.isInstance(currComp)) {
					
				}
				
				stack.pop();
				
				if ((JSONArrayComposite.class.isInstance(currComp)
						|| JSONMapComposite.class.isInstance(currComp))
						&& stack.isEmpty()) {
					break;
				}
				currComp = stack.peek();
				if (JSONKeyComposite.class.isInstance(currComp)) {
					stack.pop();
					currComp = stack.pop();
					
					if (stack.isEmpty()){
						stack.push(currComp);
					}
					
					prevComp = stack.peek();					
					stack.push(currComp);
				}
				
			}
		}
		component = currComp;
	}

	
	// Returns a new char[] that does not have spaces outside of quotes in the original
	public static char[] filterSpacesNotInQuotes(char[] charArray) {
		boolean inQuotes = false;
		char[] filteredArray = new char[charArray.length];
		char currChar;
		int j = 0;
		
		for (int i = 0; i< charArray.length; i++) {
			currChar = charArray[i];
			if (currChar == '"') {
				inQuotes = !inQuotes;
			}
			if ((currChar == ' ' || currChar == '\t' || currChar == '\n') && !inQuotes) {
				continue;
			}
			filteredArray[j] = currChar;
			j++;
		}
		return filteredArray;
	}
	
	// Prints the stack elements
	public static <T> void printStackElements(Stack<T> stack) {
		List<T> list = new ArrayList<T>();
		list.addAll(stack);
		
		System.out.println("[");
		for (T e : list) {
			System.out.println(e.getClass().toString() + ", ");
		}
		System.out.println("]");
	}
	
	@Override
	public String toString() {
		return component.toString();
	}
}
