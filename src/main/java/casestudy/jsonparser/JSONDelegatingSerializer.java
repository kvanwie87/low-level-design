package casestudy.jsonparser;
import java.util.Map;

import casestudy.jsonparser.JSONToken.JSONTokenType;

public class JSONDelegatingSerializer implements JSONDeserializer {
	private Map<JSONTokenType, JSONDeserializer> delegates;
	
	public JSONDelegatingSerializer(Map<JSONTokenType, JSONDeserializer> delegates) {
		this.delegates = delegates;
	}

	@Override
	public JSONNode deserialize(JSONToken token) {
		return delegates.get(token.type).deserialize(token);
	}

}
