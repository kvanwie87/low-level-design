package casestudy.jsonparser;

import java.util.Iterator;

public interface JSONNode {
	public String asText();
	public boolean isContainerNode();
	public boolean isValueNode();
	public JSONNode get(String field);
	public Iterator<String> getFields();
}
