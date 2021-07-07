package main.dialogs;

import java.io.File;
import java.io.IOException;

import main.decoders.*;
import main.objectifiers.*;
import main.string_handlers.*;

public class driver {

	public static void main(String[] args) {
		
		boolean print = false;
		boolean save  = false;
		for (String s : args) {
			if (s.equalsIgnoreCase("print")) {
				print = true;
			}
			else if (s.equalsIgnoreCase("save")) {
				save = true;
			}
			if (print && save)
				break;
		}
		
		// Initialize DataFormatDialog
		DataFormatDialog dialog = new DataFormatDialog();
		
		// Initialize JSONObjectifier
		JSONObjectifier jsonObjectifier = new JSONObjectifier("decorator");
		dialog.setObjectifier(jsonObjectifier);
		
		String suggestedDirectory = "C:\\Users\\Eric\\OneDrive\\Documents\\"
				+ "Rowan University\\Advanced Object Oriented Programming\\"
				+ "Advanced_Object_Oriented_Programming_Assignments\\"
				+ "Assignment_1-Creational_Patterns\\DataFormatConverter\\"
				+ "src\\main\\dialogs\\input";
		
		dialog.showDialog("open", suggestedDirectory, null);
		
		File inputFile = dialog.getFile();
		
		if (inputFile == null) {
			System.out.println("No input file selected");
			System.exit(0);
		}
		
		// if the selected file is a .csv file
		File tempFile = inputFile;
		if (inputFile.getName().matches(".*.csv$")) {
			dialog.setDecoder(new CSVtoJSONDecoder());
			String json_output = dialog.getDecoder().convertDataFormat(inputFile);
			
		    // create temporary file
			tempFile = new File(inputFile.getName().replace(".csv", ".tmp"));
			tempFile.deleteOnExit();

		    // print path
		    System.out.println(tempFile.getAbsolutePath());

		    dialog.setStrategy(new StringHandlerFileSaveStrategy(tempFile));
		    dialog.getStrategy().handleString(json_output);
			
		}
		
		// run objectify method
		dialog.getObjectifier().objectify(tempFile);
		
		// save the file we want to save to in the state of dialog
		dialog.showDialog("save",
				inputFile.toPath().getParent().toString().replace("input", "output"),
				inputFile.getName().replace(".csv", ".json"));
		
		
		// Strategy Pattern in effect
		if (save) {
			if (dialog.getStrategy() == null) {
				dialog.setStrategy(new StringHandlerFileSaveStrategy(dialog.getFile()));
			}
			((StringHandlerFileSaveStrategy) dialog.getStrategy()).setFile(dialog.getFile());
			dialog.getStrategy().handleString(dialog.getObjectifier().toString());;
		}
		if (print) {
			dialog.setStrategy(new StringHandlerPrintStrategy());
			dialog.getStrategy().handleString(dialog.getObjectifier().toString());
		}

	}

}
