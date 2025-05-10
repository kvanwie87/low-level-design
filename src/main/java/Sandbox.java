import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

public class Sandbox {

    public class DTO {
        private String value;

        public DTO(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Map<String, String> getLookUpValues() { // Note the return type is Map<String, String> so it is pretty obvious what the end result is
        Map<String, DTO> lookupMap = new ConcurrentHashMap<>();
        lookupMap.put("key1", new DTO("value1"));
        lookupMap.put("key2", new DTO("value2"));
        // First thing the real function did was populate the map with the LookupList

        Optional<Map<String, DTO>> mapOpt = ofNullable(lookupMap); // ofNullable is a helper method in the Optional class that returns an Optional describing the specified value, if non-null, otherwise an empty Optional
        Optional<Set<Map.Entry<String, DTO>>> mapEntries = mapOpt.map(Map::entrySet); // This will convert the Map to a set of Map.Entry<String, DTO>
        Stream<Set<Map.Entry<String, DTO>>> entrySetStream = mapEntries.stream(); // Makes a stream of Sets, note that there is only 1 set though
        Stream<Map.Entry<String, DTO>> entryStream = entrySetStream.flatMap(Collection::stream); // This will flatten the stream of Sets to a stream of Map.Entry<String, DTO>
        Map<String, String> result = entryStream
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getValue())); // This will convert the stream of Map.Entry<String, DTO> to a Map<String, String>,
                                                                                                     // specifying the key is just the key from the entry and value is the value which is a DTO object .getValue()
        return result; // End result is a Map<String, String> that was originally a Map<String, DTO>
    }

    public Map<String, String> getLookUpValues_ForLoopForUnderstanding() {
        // This is just a functionally equivalent version of the above function but using a for loop instead of streams
        Map<String, DTO> lookupMap = new ConcurrentHashMap<>();
        lookupMap.put("key1", new DTO("value1"));
        lookupMap.put("key2", new DTO("value2"));

        Map<String, String> result = new ConcurrentHashMap<>();
        for(Map.Entry<String, DTO> entry : lookupMap.entrySet()) { // This is a for loop that iterates over the Map<String, DTO>
            String key = entry.getKey(); // Get the key from the entry
            String value = entry.getValue().getValue(); // Get the value from the entry which is a DTO object and call .getValue() on it
            result.put(key, value);
        }
        return result;
    }
}
