package casestudy.jsonparser;

public class TextNode extends ValueNode {
	private String value;
	public TextNode(String value) {
		this.value = value;
	}

	public String asText() {
		return value;
	}
}
