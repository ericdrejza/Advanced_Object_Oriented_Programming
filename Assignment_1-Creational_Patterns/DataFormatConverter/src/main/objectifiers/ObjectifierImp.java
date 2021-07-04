package main.objectifiers;

import java.io.File;

import main.decoders.ParserBuilder;
import main.decoders.ProductBuilder;

public abstract class ObjectifierImp {
	protected ParserBuilder parserBuilder;
	protected ProductBuilder productBuilder;
	
	abstract void objectify(File file);
	abstract ParserBuilder parserBuilderFactoryMethod();
	abstract ProductBuilder productBuilderFactoryMethod();
}
