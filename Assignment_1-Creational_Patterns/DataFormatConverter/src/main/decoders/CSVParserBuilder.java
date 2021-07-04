package main.decoders;

import java.io.File;

//Eric Drejza
//Advanced Object Oriented Programming
//6/18/2021
//Assignment 1 - Creational Patterns

public class CSVParserBuilder extends ParserBuilder {
	
	@Override
	public String[][] parseData(File file) {
		String[] lines = lineSeparator(file);
		int num_terms = lines[0].split(",").length;
		
		String[][] parsedData = new String[lines.length][num_terms];
		
		// Split each line by comma, and iterate through each term
		// placing each term into a column as it increments
		for (int r = 0; r < lines.length; r++) {
			String[] terms = lines[r].split(",");
			for (int c = 0; c < num_terms; c++) {
				String term = terms[c].trim().replaceAll("^\"", "").replaceAll("\"$", "");
				parsedData[r][c] = term;
			}
		}
		
		return parsedData;
	}

}
