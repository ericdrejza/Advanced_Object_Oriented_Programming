package main.decoders;

import java.io.File;

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
	
	public String convertDataFormat(File file) {
		parserBuilder = parserBuilderFactoryMethod();
		String[][] parsedData = parserBuilder.parseData(file);
		
		productBuilder = productBuilderFactoryMethod();
		String newlyFormattedData = productBuilder.formatData(parsedData);
		
		return newlyFormattedData;
	}
}
