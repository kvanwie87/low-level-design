package casestudy.jsonparser;

public class JSONStringDeserializer implements JSONDeserializer {

	@Override
	public JSONNode deserialize(JSONToken token) {
		return new TextNode(token.valueStr);
	}

}
