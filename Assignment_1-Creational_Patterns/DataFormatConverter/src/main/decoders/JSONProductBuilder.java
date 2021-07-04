package main.decoders;

//Eric Drejza
//Advanced Object Oriented Programming
//6/18/2021
//Assignment 1 - Creational Patterns

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONProductBuilder extends ProductBuilder {

	@Override
	String formatData(String[][] data) {
		if (data == null || data.length == 0) {
			System.out.println("Data is empty");
			return null;
		}
		
		List<LinkedHashMap<String, String>> json_map_list = new ArrayList<LinkedHashMap<String, String>>(data.length-1);
		
		for (int r = 1; r < data.length; r++) {
			LinkedHashMap<String,String> currMap = new LinkedHashMap<String, String>();
			json_map_list.add(currMap);
			for (int c = 0; c < data[r].length; c++) {
				currMap.put(data[0][c], data[r][c]);
			}
		}
		
		String json_string = "[\n";
		
		for (int i = 0; i < json_map_list.size(); i++) {
			LinkedHashMap<String,String> currMap = json_map_list.get(i);
			Iterator<String> key_it = currMap.keySet().iterator();
			json_string = json_string + "\t{\n";
			
			while (key_it.hasNext()) {
				String currKey = key_it.next();
				json_string = json_string + "\t\t\"" + currKey + "\": \"" + currMap.get(currKey) + "\"";
				if (key_it.hasNext()) {
					json_string = json_string + ",\n";
				}
				else {
					json_string = json_string + "\n";
				}
			}
			
			if (i + 1 == json_map_list.size()) {
				json_string = json_string + "\t}\n";
			}
			else {
				json_string = json_string + "\t},\n";				
			}
		}
		json_string = json_string + "]";
		return json_string;
	}
	
}
