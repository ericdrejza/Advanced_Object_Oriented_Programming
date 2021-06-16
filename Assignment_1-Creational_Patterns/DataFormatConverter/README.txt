Eric Drejza
Advanced Object Oriented Programming
6/18/2021
Assignment 1 - Creational Patterns

A quick preface to this, I held off on appending the name
of the patterns to each of my class's names because all
of my classes are part of the two design patterns I'm using
and I figured what's the point of using these names to
distinguish what patterns they belong to when every class
belongs to both patterns.  Hopefully that's alright, sorry
if there was another reason you wanted the names appended
other than the one I listed.

Design Patterns Selected:
Builder:
	Director		--> CSVtoJSONDecoder
	Builder			--> ParserBuilder, ProdcutBuilder
	ConcreteBuilder	-->	CSVParserBuilder, JSONProductBuilder 


Factory Method:
	Creator			--> AbstractDecoder
	ConcreteCreator	--> CSVtoJSONDecoder
	FactoryMethod	-->	parserBuilderFactoryMethod(), productBuilderFactoryMethod()
	Product 		-->	ParserBuilder, ProductBuilder
	ConcreteProduct -->	CSVParserBuilder, JSONProductBuilder

Usage:
To run this program.  Have a csv formatted file ready and run the driver.java main method.
This will open a file dialog for you to select your input file.
Once you have selected your input file, click the "Open" button on the dialog window.

Next it will ask you to save a file.  This is where your json output will be saved to.
Once you have a file chosen, click save and the json formatted data will be written to that file.