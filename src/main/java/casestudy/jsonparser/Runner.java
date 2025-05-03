package casestudy.jsonparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import casestudy.jsonparser.JSONToken.JSONTokenType;

public class Runner {
	public static void main(String[] args) {
		JSONNode json = getJson("json text here");
		if(json.isContainerNode()) {
			Iterator<String> fieldNames = json.getFields();
			while(fieldNames.hasNext()) {
				JSONNode node = json.get(fieldNames.next());
			}
		} else {
			json.asText();
		}
		//((ValueNode)((ContainerNode)((ContainerNode)json).get("name")).get("firstName")).asText();
		json.get("name").get("firstName").asText();
		
		JSONTokenizer jsonTokenizer = new JSONTokenizer();
		Map<JSONTokenType, JSONDeserializer> deserializers = new HashMap<JSONToken.JSONTokenType, JSONDeserializer>();
		deserializers.put(JSONTokenType.STRING_TYPE, new JSONStringDeserializer());
		JSONDelegatingSerializer delegatingSerializer = new JSONDelegatingSerializer(deserializers);
		JSONParserImpl jsonParserImpl = new JSONParserImpl(jsonTokenizer , delegatingSerializer);
	}
	
	public static JSONNode getJson(String jsonString) {
		return new ObjectNode();
	}
}
