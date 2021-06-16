package main.decoders;

//Eric Drejza
//Advanced Object Oriented Programming
//6/18/2021
//Assignment 1 - Creational Patterns

public class CSVtoJSONDecoder extends AbstractDecoder {

	@Override
	ParserBuilder parserBuilderFactoryMethod() {
		return new CSVParserBuilder();
	}

	@Override
	ProductBuilder productBuilderFactoryMethod() {
		return new JSONProductBuilder();
	}

}
