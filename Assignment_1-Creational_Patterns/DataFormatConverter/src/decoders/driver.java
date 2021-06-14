package decoders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class driver {
	
	public static void main(String[] args) {
		CSVtoJSONDecoder decoder = new CSVtoJSONDecoder();
		String csvInputData = "";
		File selectedSourceFile = chooseFile("open");
		try {
			Scanner scnr = new Scanner(selectedSourceFile);
			while(scnr.hasNextLine()) {
				csvInputData = csvInputData + scnr.nextLine() + "\n";
			}
			scnr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Input (csv):\n\n" + csvInputData + "\n\n");
		
		String json_out = decoder.convertDataFormat(csvInputData);
		
		System.out.println("Output (json):\n\n" + json_out);
		
		File selectedSaveFile = chooseFile("save");
		
		// TODO: Save json data to .json file 
		
	}

	
	private static File chooseFile(String option) {
		JFileChooser fileChooser = new JFileChooser();
		String startingDirectory = 
				"C:\\Users\\Eric\\OneDrive\\Documents\\"
				+ "Rowan University\\Advanced Object Oriented Programming\\"
				+ "Advanced_Object_Oriented_Programming_Assignments\\"
				+ "Assignment_1-Creational_Patterns\\DataFormatConverter\\"
				+ "src\\decoders\\";
		switch (option) {
		case "open":
			startingDirectory = startingDirectory + "input";
			fileChooser.setCurrentDirectory(new File(startingDirectory));
			fileChooser.showOpenDialog(null);			
			break;
		case "save":
			startingDirectory = startingDirectory + "output";
			fileChooser.setCurrentDirectory(new File(startingDirectory));
			fileChooser.showSaveDialog(null);
			break;
		}
		
		return fileChooser.getSelectedFile();
	}
	
}
