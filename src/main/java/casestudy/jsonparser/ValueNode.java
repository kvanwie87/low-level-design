package casestudy.jsonparser;

import java.util.Iterator;

public abstract class ValueNode extends BaseJSONNode {
	@Override
	public boolean isContainerNode() {
		return false;
	}
	@Override
	public boolean isValueNode() {
		return true;
	}
	@Override
	public JSONNode get(String field) {
		return null;
	}
	@Override
	public Iterator<String> getFields() {
		return null;
	}
}
