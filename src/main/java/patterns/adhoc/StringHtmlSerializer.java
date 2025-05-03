package patterns.adhoc;

public class StringHtmlSerializer implements HTMLSerializer<String>{

	@Override
	public String serialize(String value) {
		return "<div>"+value+"</div>";
	}

}
