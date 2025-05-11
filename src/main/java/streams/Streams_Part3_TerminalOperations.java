package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams_Part3_TerminalOperations {
    public static void main(String[] args) {
        // Terminal operations are operations that return a result or a side effect and terminate the stream
        // They cause the intermediate operations to be executed
        // Examples of terminal operations are: forEach, collect, reduce, count, min, max, anyMatch, allMatch, noneMatch, findFirst, findAny, etc.

        Stream<String> stringStream = Stream.of("a", "b", "c");

        // forEach is a terminal operation that applies a consumer to each element in the stream
        stringStream.forEach(System.out::println);

        // reduce is a terminal operation that takes a binary operator and combines the elements in the stream into a single result
        // reduce can also take an identity value and a binary operator
        stringStream.reduce((s1, s2) -> s1 + s2); // This will concatenate all the elements in the stream into a single string
        stringStream.reduce("InitialValue", (s1, s2) -> s1 + s2); // This will concatenate all the elements in the stream into a single string, starting with the identity value

        stringStream.count(); // This will return the number of elements in the stream. This will cause all the intermediate operations to be executed
        stringStream.min((s1, s2) -> {
            return s1.length() - s2.length(); // This will return the minimum element in the stream using a comparator. In this case it will return the shortest string
        }); // This will return the minimum element in the stream using a comparator

        stringStream.findFirst(); // This will return the first element in the stream
        stringStream.findAny(); // This will return any element in the stream. This is useful for parallel streams where the order of the elements is not guaranteed
        stringStream.allMatch(s -> s.length() > 0); // This will return true if all the elements in the stream match the predicate.


        // collect is a terminal operation that collects the elements in the stream into a collection
        // The most terminal operations are collect and reduce
        // collect takes a collector and collects the elements in the stream into a collection
        // The most common collector is Collectors.toList() which collects the elements in the stream into a list
        // There are many other collectors available in the Collectors class
        stringStream.collect(Collectors.toList()); // This will collect the elements in the stream into a list
        stringStream.toList(); // This is a shorthand for Collectors.toList() and is available in Java 16 and later
        stringStream.collect(Collectors.toSet()); // This will collect the elements in the stream into a set
        stringStream.collect(Collectors.toMap(s -> s, s -> s.length())); // This will collect the elements in the stream into a map where the key is the element and the value is the length of the element

        // There is other collectors available in the Collectors class
        // The most common ones are: toList, toSet, toMap
    }
}
