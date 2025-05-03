package casestudy.jsonparser;

public class JSONToken {
	public String fieldName;
	public String valueStr;
	public JSONTokenType type;
	
	
	public JSONToken(String fieldName, String valueStr, JSONTokenType type) {
		this.fieldName = fieldName;
		this.valueStr = valueStr;
		this.type = type;
	}
	
	public static JSONToken createStringToken(String fieldName, String valueStr) {
		return new JSONToken(fieldName, valueStr, JSONTokenType.STRING_TYPE);
	}
	
	public static JSONToken createObjectToken(String fieldName, String valueStr) {
		return new JSONToken(fieldName, valueStr, JSONTokenType.OBJECT_TYPE);
	}

	public enum JSONTokenType {
		STRING_TYPE,
		NUMERIC_TYPE,
		OBJECT_TYPE,
		ARRAY_TYPE
	}
}
