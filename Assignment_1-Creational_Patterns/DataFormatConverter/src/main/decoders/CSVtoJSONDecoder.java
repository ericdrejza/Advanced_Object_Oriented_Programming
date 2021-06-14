package main.decoders;

public class CSVtoJSONDecoder extends AbstractDecoder {

	@Override
	ParserBuilder parserBuilderFactoryMethod() {
		return new CSVParserBuilder();
	}

	@Override
	ProductBuilder productBuilderFactoryMethod() {
		return new JSONProductBuilder();
	}

}
