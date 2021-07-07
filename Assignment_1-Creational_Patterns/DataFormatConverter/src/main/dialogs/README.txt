Eric Drejza
Advanced Object Oriented Programming
07/06/2021
Assignment 3 - Behavioral Patterns

Structural Design Patterns Selected:

Strategy:
(seen in main.dialog and main.string_handlers packages)
	Context				--> DataFormatDialogMediator
	Strategy			--> StringHandlerStrategy
	ConcreteStratgey	-->	StringHandlerPrintStrategy,
							StringHandlerFileSaveStrategy 

Iterator: (Kinda deviates from the pattern, but it's an iterator nonetheless.)
(seen in main.objectifiers.iterators package)
	Aggregate			--> JSONComponentDecorator
	ConcreteAggregate	--> JSONLine, JSONNewLineDecorator
	Iterator			-->	Iterator
	ConcreteIterator	--> DecoratorIterator
	

Usage:
To run this program.  Have a .csv or .json file (formatted appropriately to match the file extension)
ready and run the driver.java main method in package main.dialog with the string "print" and/or "save"
passed as an argument or arguments if you choose to pass them both.

This will argument will tell the program you want to either want to print out your json string product
to standard out, save it to a file, or both.


After you've run driver.java:
This will open a file dialog for you to select your input file.
Once you have selected your input file, click the "Open" button on the dialog window.

If the file is in csv format, it will be converted to json, then the either the newly converted json
or the original json input data will be objectified and then either printed out and/or saved based on
your arguments "print" and/or "save" passed to the main method.

The current driver being used uses the JSONObjectifierDecoratorImp to work with the new iterator
I created as part of the Iterator pattern, and the two options for printing and saving are done
using the Strategy pattern.