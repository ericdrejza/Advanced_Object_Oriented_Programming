package main.decoders;

import java.io.File;
import java.util.ArrayList;

public class JSONParserBuilder extends ParserBuilder {

	@Override
	public String[][] parseData(File file) {
		String[] lines = lineSeparator(file);
		
		int max_terms = 0;
		int num_terms;
		String[] terms;
		ArrayList<String[]> list_of_terms = new ArrayList<String[]>();
		
		for (int i = 0; i < lines.length; i++) {
			// split on white space with an even number of Quotes
			terms = lines[i].split("");
			list_of_terms.add(terms);
			num_terms = terms.length;
			if (num_terms > max_terms) {
				max_terms = num_terms;
			}
		}
		
		String[][] parsedData = new String[list_of_terms.size()][max_terms];
		
		for (int i = 0; i < list_of_terms.size(); i++) {
			parsedData[i] = list_of_terms.get(i);
		}
		
		return parsedData;
	}

	
	public static void main(String[] args) {
		
	}
}
