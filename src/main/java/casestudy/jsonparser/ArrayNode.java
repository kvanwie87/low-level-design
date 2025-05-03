package casestudy.jsonparser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayNode extends ContainerNode {
	List<JSONNode> children = new ArrayList<JSONNode>();
	@Override
	public JSONNode get(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<String> getFields() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JSONNode get(int index) {
		return children.get(index);
	}

}

//{
//	"someArray" : [
//	               {"field":1},
//	               {"field":2}, 
//	               {"field":3}
//	               ],
//	"someObject" : {
//		"innerField" : {
//			"inberinerFIeld"
//		},
//		"innerField2": false
//	}
//}