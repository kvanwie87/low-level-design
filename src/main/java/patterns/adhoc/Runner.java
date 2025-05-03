package patterns.adhoc;
//import static patterns.adhoc.AdHocHtmlSerializer.*;
import static patterns.adhoc.AdHocHtmlSerializerV2.*;
public class Runner {
	public static void main(String[] args) {
		StringHtmlSerializer serializer = new StringHtmlSerializer();
		HTMLSerializer<Integer> myIntSerializer = new HTMLSerializer<Integer>() {
			@Override
			public String serialize(Integer value) {
				return "<div>"+value+"</div>";
			}
			
		};
		//System.out.println(serializer.serialize("HELLO"));
		//System.out.println(myIntSerializer.serialize(1));
		//System.out.println(serialize(1));
		//System.out.println(serialize("HELLO"));
		System.out.println(serialize(1, myIntSerializer));
		System.out.println(serialize("HELLO", serializer));
	}
}
