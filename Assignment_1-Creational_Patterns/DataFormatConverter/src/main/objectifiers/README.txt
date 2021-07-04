Eric Drejza
Advanced Object Oriented Programming
07/03/2021
Assignment 2 - Structural Patterns

Structural Design Patterns Selected:
Bridge:
	Abstraction			--> Objectifier
	Implementor			--> ObjectifierImp, JSONObjectifierImp
	RefinedAbstractions	-->	JSONObjectifier 
	ConcreteImplementor --> JSONObjectifierCompositeImp, JSONObjectifierDecoratorImp


Composite:
	Component		--> JSONComponentComposite
	Composite		--> JSONMapComposite, JSONArrayComposite, JSONKeyComposite
	Leaf			-->	JSONTerminalValue


Composite:
	Component			--> JSONComponentDecorator
	Decorator			--> JSONDecorator
	ConcreteDecorator	--> JSONNewLineDecorator
	ConcreteComponent	-->	JSONLine
	

Usage:
To run this program.  Have a json formatted file ready and run the driver.java main method.
This will open a file dialog for you to select your input file.
Once you have selected your input file, click the "Open" button on the dialog window.

The json input data will be objectified and then printed out as the objects are traversed.
There will be three sections of outputs on the console, first, your input json, and then the
the output of each of the ObjectifierImps will be printed as well specifying which implementation
was used.

If for some reason you would like to save each json output to a file, you can uncomment the code
in the for loop in the driver class's main method and it will ask you for files to save them to.