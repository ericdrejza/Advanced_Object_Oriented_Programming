package main.dialogs;

import java.io.File;

import javax.swing.JFileChooser;

import main.decoders.*;
import main.objectifiers.*;
import main.string_handlers.StringHandlerStrategy;

public abstract class Dialog {
	AbstractDecoder decoder;
	Objectifier objectifier;
	StringHandlerStrategy strategy;
	File file;
	
	public void showDialog(String option, String suggestedDirectory, String suggestedFilename) {
		File suggestedDirectoryFile;
		if (suggestedDirectory != null) {
			suggestedDirectoryFile = new File(suggestedDirectory);			
		}
		else {
			suggestedDirectoryFile = null;
		}
		
		File suggestedFilenameFile;
		if (suggestedFilename != null) {
			suggestedFilenameFile = new File(suggestedFilename);			
		}
		else {
			suggestedFilenameFile = null;
		}
		
		JFileChooser fileChooser = new JFileChooser();
		switch (option) {
		case "open":
			fileChooser.setCurrentDirectory(suggestedDirectoryFile);
			fileChooser.showOpenDialog(null);			
			break;
		case "save":
			fileChooser.setCurrentDirectory(suggestedDirectoryFile);
			fileChooser.setSelectedFile(new File(suggestedFilename));
			fileChooser.showSaveDialog(null);
			break;
		}
		
		file = fileChooser.getSelectedFile();
	}
	
	// Getters and Setters
	public AbstractDecoder getDecoder() {
		return decoder;
	}
	public void setDecoder(AbstractDecoder decoder) {
		this.decoder = decoder;
	}
	
	public Objectifier getObjectifier() {
		return objectifier;
	}
	public void setObjectifier(Objectifier objectifier) {
		this.objectifier = objectifier;
	}
	
	public StringHandlerStrategy getStrategy() {
		return strategy;
	}
	public void setStrategy(StringHandlerStrategy strategy) {
		this.strategy = strategy;
	}
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
		
}
