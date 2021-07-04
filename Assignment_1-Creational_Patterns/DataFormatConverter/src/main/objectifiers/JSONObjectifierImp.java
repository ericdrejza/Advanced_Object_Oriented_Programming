package main.objectifiers;

import java.io.File;

import main.decoders.ParserBuilder;
import main.decoders.ProductBuilder;
import main.decoders.JSONParserBuilder;
import main.decoders.JSONProductBuilder;

public abstract class JSONObjectifierImp extends ObjectifierImp {
	
	JSONObjectifierImp(){
		parserBuilder = parserBuilderFactoryMethod();
		productBuilder = productBuilderFactoryMethod();
	}
	
	@Override
	ParserBuilder parserBuilderFactoryMethod() {
		return new JSONParserBuilder();
	}

	@Override
	ProductBuilder productBuilderFactoryMethod() {
		return new JSONProductBuilder();
	}

}
