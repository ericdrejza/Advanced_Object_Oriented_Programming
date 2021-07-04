package main.objectifiers;

//Eric Drejza
//Advanced Object Oriented Programming
//7/2/2021
//Assignment 2 - Structural Patterns

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class driver {
	/*
	
	*/
	
	public static void main(String[] args) {
		String suggestedDirectory = "C:\\Users\\Eric\\OneDrive\\Documents\\"
				+ "Rowan University\\Advanced Object Oriented Programming\\"
				+ "Advanced_Object_Oriented_Programming_Assignments\\"
				+ "Assignment_1-Creational_Patterns\\DataFormatConverter\\"
				+ "src\\main\\objectifiers\\input";
		
		String jsonInputData = "";
		File selectedSourceFile = chooseFile("open", suggestedDirectory, "");
//		File selectedSourceFile = new File(suggestedDirectory.toString()+"\\superheroes.json");
		System.out.println(selectedSourceFile.getAbsolutePath());
		
		// Read input data
		if (selectedSourceFile != null) {
			try {
				Scanner scnr = new Scanner(selectedSourceFile);
				while(scnr.hasNextLine()) {
					jsonInputData = jsonInputData + scnr.nextLine() + "\n";
				}
				scnr.close();
			}
			catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}	
			
			// Print input data
			System.out.println("Input (JSON):\n\n" + jsonInputData + "\n");
			
			String[] impOptions = new String[] {"Composite", "Decorator"};
			
			
			// Instantiate JSONObjectifier
			JSONObjectifier jsonObjectifier = new JSONObjectifier();
			
			// Loop through implementations and print outputs
			for (String imp : impOptions) {
				// Set implementation
				jsonObjectifier.setImp(imp);
				
				// Objectifier objectifies
				jsonObjectifier.objectify(selectedSourceFile);
				String json_out = jsonObjectifier.toString();
				
				// Print newly output data
				System.out.println("\n\nOutput (json with " + imp + " Implementation):\n\n" + json_out + "\n\n");				

				
//				// Save json_out to .json file 
//				File selectedSaveFile = chooseFile("save",
//						selectedSourceFile.toPath().getParent().toString(),
//						selectedSourceFile.getName().replace("input", "output"));
//				
//				
//				if (selectedSaveFile != null) {
//					try {
//						FileWriter writer = new FileWriter(selectedSaveFile);
//						writer.write(json_out);
//						writer.flush();
//						writer.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						System.out.println(e.getMessage());
//						e.printStackTrace();
//					}
//				}
			}
			
		}
	}

	
	private static File chooseFile(String option, String suggestedDirectory, String suggestedFilename) {
		JFileChooser fileChooser = new JFileChooser();
		switch (option) {
		case "open":
			fileChooser.setCurrentDirectory(new File(suggestedDirectory));
			fileChooser.showOpenDialog(null);			
			break;
		case "save":
			fileChooser.setCurrentDirectory(new File(suggestedDirectory));
			fileChooser.setSelectedFile(new File(suggestedFilename));
			fileChooser.showSaveDialog(null);
			break;
		}
		
		return fileChooser.getSelectedFile();
	}
	
}