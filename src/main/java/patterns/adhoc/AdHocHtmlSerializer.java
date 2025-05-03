package patterns.adhoc;

public class AdHocHtmlSerializer {
	private static StringHtmlSerializer stringHtmlSerializer = new StringHtmlSerializer();
	private static HTMLSerializer<Integer> myIntSerializer = new HTMLSerializer<Integer>() {
		@Override
		public String serialize(Integer value) {
			return "<div>"+value+"</div>";
		}
		
	};
	public static String serialize(String value) {
		return stringHtmlSerializer.serialize(value);
	}
	public static String serialize(Integer value) {
		return myIntSerializer.serialize(value);
	}
}
