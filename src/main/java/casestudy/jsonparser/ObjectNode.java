package casestudy.jsonparser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectNode extends ContainerNode {
	private Map<String, JSONNode> children;
	
	public ObjectNode() {
		children = new HashMap<String, JSONNode>();
	}
	
	@Override
	public JSONNode get(String fieldName) {
		return children.get(fieldName);
	}

	@Override
	public Iterator<String> getFields() {
		return children.keySet().iterator();
	}
	
	public void addField(String key, JSONNode value) {
		children.put(key, value);
	}
}
