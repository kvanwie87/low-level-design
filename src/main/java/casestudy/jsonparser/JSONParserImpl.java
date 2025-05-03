package casestudy.jsonparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class JSONParserImpl {
	private JSONTokenizer jsonTokenizer;
	private JSONDeserializer deserializer;
	
	
	
	public JSONParserImpl(JSONTokenizer jsonTokenizer, JSONDeserializer deserializer) {
		this.jsonTokenizer = jsonTokenizer;
		this.deserializer = deserializer;
	}

	public JSONNode getJSON(String jsonStr) {
		//Validation
		List<JSONToken> tokens = jsonTokenizer.tokenize(jsonStr);
		ObjectNode obj = new ObjectNode();
		for(JSONToken token : tokens) {
			String currKey = token.fieldName;
			obj.addField(currKey, deserializer.deserialize(token));
		}
		return obj;
	}

}
