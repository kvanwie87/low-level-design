package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMethodReferenceOperator {
    /***
     You would use the method reference operator Collection::stream when you want to create a stream from a nest collection.
     Collections inside another collection or Collections inside of Optional are common use cases for this.
     This is a shorthand for the lambda expression collection -> collection.stream()

    ***/

    public static void main(String[] args) {
        // Example usage of the method reference operator Collection::stream
        // Assuming you have a Optional of a collection
        Optional<List<String>> optionalCollection = Optional.of(Arrays.asList("a", "b", "c"));

        // You can not directly call stream() on the Optional, but you can use the method reference operator to create a stream from the collection inside the Optional
        optionalCollection
                .map(Collection::stream) // This is the method reference operator, it creates a stream from the collection inside the Optional
                .ifPresent(stream -> stream.forEach(System.out::println)); // This will print each element in the stream

        // Another example is when you have n
        List<List<String>> nestedCollection = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        // You can use the method reference operator to create a stream from each collection inside the nested collection
        nestedCollection
                .stream() // This creates a stream from the outer collection
                .map(Collection::stream) // This uses the method reference operator to create a stream from each inner collection
                .forEach(innerStream -> innerStream.forEach(System.out::println)); // This will print each element in each inner stream
        // Similar to the above you can flatten the stream of streams into a single stream
        nestedCollection
                .stream() // This creates a stream from the outer collection
                .flatMap(Collection::stream) // This uses the method reference operator to flatten the stream of streams into a single stream
                .forEach(System.out::println); // This will print each element in the flattened stream


        Map<String, String> innerMap = new HashMap<>();
        Optional<Map<String, String>> optionalMap = Optional.of(innerMap);
        // The sample code you provided did the below which is a bit convoluted
        var result = optionalMap
                .map(Map::entrySet)// Optional<Map<String, String>> to Optional<Set<Map.Entry<String, String>>>
                .stream() // Optional<Set<Map.Entry<String, String>>> to Stream<Set<Map.Entry<String, String>>> this is just a stream with a single Set in it
                .flatMap(Collection::stream) // Stream<Set<Map.Entry<String, String>>> to Stream<Map.Entry<String, String>> this is flattening the stream of a single set into a stream of entries
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // This will convert the stream of Map.Entry<String, String> to a Map<String, String>

        // In my opinion this equivalent code is much easier to read
        var result2 = optionalMap.map(map -> {
            return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }).orElse(Collections.emptyMap());

    }
}
