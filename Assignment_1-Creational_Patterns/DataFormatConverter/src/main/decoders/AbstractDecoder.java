package main.decoders;

//Eric Drejza
//Advanced Object Oriented Programming
//6/18/2021
//Assignment 1 - Creational Patterns

import java.util.List;
import java.util.Map;

public abstract class AbstractDecoder {
	ParserBuilder parserBuilder;
	ProductBuilder productBuilder;
	
	abstract ParserBuilder parserBuilderFactoryMethod();
	abstract ProductBuilder productBuilderFactoryMethod();
	
	public String convertDataFormat(String data) {
		parserBuilder = parserBuilderFactoryMethod();
		String[][] parsedData = parserBuilder.parseData(data);
		
		productBuilder = productBuilderFactoryMethod();
		String newlyFormattedData = productBuilder.convertData(parsedData);
		
		return newlyFormattedData;
	}
}
