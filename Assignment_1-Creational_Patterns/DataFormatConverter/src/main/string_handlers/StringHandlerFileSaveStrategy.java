package main.string_handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class StringHandlerFileSaveStrategy extends StringHandlerStrategy {
	File file;
	
	public StringHandlerFileSaveStrategy() {}
	
	public StringHandlerFileSaveStrategy(File file) {
		this.file = file;
	}
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	@Override
	public void handleString(String string) {		
		// Save json_out to .json file 		
		if (file != null) {
			try {
				FileWriter writer = new FileWriter(file);
				writer.write(string);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
}
