package decoders;

public class CSVParserBuilder extends ParserBuilder {

	@Override
	String[][] parseData(String data) {
		
		String[] lines = data.split("\\n");
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
