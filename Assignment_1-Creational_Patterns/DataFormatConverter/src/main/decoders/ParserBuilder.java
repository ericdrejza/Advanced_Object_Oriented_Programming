package main.decoders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Eric Drejza
//Advanced Object Oriented Programming
//6/18/2021
//Assignment 1 - Creational Patterns

public abstract class ParserBuilder {
	public abstract String[][] parseData(File file);
	
	public String[] lineSeparator(File file) {
		ArrayList<String> linesAL = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(file);			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				linesAL.add(line);
			}
			bufferedReader.close();
		}
		catch(IOException fne) {
			fne.printStackTrace();
			return null;
		}
		Object[] linesO = linesAL.toArray();
		String[] lines = new String[linesO.length];
		for (int i = 0; i < linesO.length; i++) {
			lines[i] = (String) linesO[i]; 
		}
		return lines;
	}
	
	public static void printParsedData(String[][] data) {
		System.out.print("[");
		for (int i = 0; i < data.length; i++) {
			System.out.print("[");
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println("]");
		}
		System.out.print("]");
	}
}
