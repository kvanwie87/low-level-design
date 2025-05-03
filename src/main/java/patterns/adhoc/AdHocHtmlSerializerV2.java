package patterns.adhoc;

public class AdHocHtmlSerializerV2 {
	public static <T> String serialize(T value, HTMLSerializer<T> serializer) {
		return serializer.serialize(value);
	}
}
                             