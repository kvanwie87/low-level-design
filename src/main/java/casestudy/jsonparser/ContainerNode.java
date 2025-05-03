package casestudy.jsonparser;

public abstract class ContainerNode extends BaseJSONNode {
	public boolean isContainerNode() {
		return true;
	}
	public boolean isValueNode() {
		return false;
	}

	@Override
	public String asText() {
		return null;
	}
}
