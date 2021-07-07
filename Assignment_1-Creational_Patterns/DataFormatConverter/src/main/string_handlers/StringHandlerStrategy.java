package main.string_handlers;

import main.dialogs.*;

public abstract class StringHandlerStrategy {
	Dialog director;
	
	public abstract void handleString(String string);
}
