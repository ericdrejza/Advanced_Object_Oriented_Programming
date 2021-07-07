package main.objectifiers;

import java.io.File;

public abstract class Objectifier {
	protected ObjectifierImp imp;
	protected File file;
	
	public void objectify(){
		imp.objectify(file);
	}
	
	public void objectify(File file) {
		this.file = file;
		objectify();
	}
	
	public ObjectifierImp getImp() {
		return imp;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return imp.toString();
	}
}
