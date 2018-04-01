package myJson.JsonObectParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONNavi;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

public class ConvertInnerJsonObjectToJsonArray {

	public static void main(String[] args) throws Exception {
		String s = "{\n  \"firstName\": \"John\",\n  \"lastName\": \"doe\",\n  \"age\": 26,\n  \"address\": {\n    \"streetAddress\": \"naist street\",\n    \"city\": \"Nara\",\n    \"postalCode\": \"630-0192\"\n  },\n  \"phoneNumbers\": [\n    {\n      \"type\": \"iPhone\",\n      \"number\": \"0123-4567-8888\"\n    },\n    {\n      \"type\": \"home\",\n      \"number\": \"0123-4567-8910\"\n    }\n  ]\n}";
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(s);
		System.out.println("json Object before\n" + obj);
		Set<String> key = obj.keySet();
		for (String k : key) {
			Object a = obj.get(k);
			if (a instanceof net.minidev.json.JSONObject) {
				Object obj1 = parser.parse(obj.getAsString(k));
				JSONArray array = new JSONArray();
				array.add(obj1);
				obj.replace(k, array);
			}
		}
		System.out.println("json Object after\n"+obj);
	}

}
