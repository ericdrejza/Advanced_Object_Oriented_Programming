package main.string_handlers;

public class StringHandlerPrintStrategy extends StringHandlerStrategy {

	public StringHandlerPrintStrategy() {}
	
	@Override
	public void handleString(String string) {
		System.out.println(string);
	}

}
