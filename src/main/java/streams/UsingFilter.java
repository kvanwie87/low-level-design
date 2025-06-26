package streams;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class UsingFilter {
    public static void main(String[] args) {
        // Filter is an intermediate operation that takes a predicate and returns a new stream
        // with only the elements that match the predicate
        // It is used to filter out elements from a stream based on a condition

        Stream<String> stringStream = Stream.of("a", "b", "c", "d", "e");

        // Example of using filter to get only elements that start with 'a'
        List<String> filteredList = stringStream
                .filter(s -> s.startsWith("a")) // This will filter the stream to only include elements that start with 'a'
                .toList(); // Collect the results into a List

        System.out.println(filteredList); // Output: [a]

        // A Predicate is a functional interface that takes an input and returns a boolean value
        Predicate<String> isLongEnough = s -> s.length() > 10; // This is a predicate that checks if the length of the string is greater than 10

        // The output of the filter operation be a stream of the same type as the original stream with only the elements that match the predicate
        // The predicate will be applied to each element in the stream


        // filter() can take in Predicate, lambda expressions, or method references
        // filter() can be chained with other stream operations including more filter() operations
        List<String> filteredList2 = Stream.of("apple", "banana", "cherry", "date")
                .filter(isLongEnough) // This will filter the stream to only include elements that match the predicate
                .filter(s -> s.contains("a")) // This will filter the stream to only include elements that contain 'a'
                .filter(StringUtils::hasText) // This is a method reference that checks if the string has text (not null or empty)
                .toList(); // Collect the results into a List

        // You can put multiple criteria in the filter operation
        Stream<String> filteredList3 = Stream.of("apple", "banana", "cherry", "date")
                .filter(s -> s.length() > 5 && s.contains("a") && StringUtils.hasText(s)); // This will filter the stream to only include elements that match all the criteria


        // filter() can also be applied to Optional
        // If the value is present and the predicate matches, it will return an Optional with the value
        // Otherwise, it will return an empty Optional
        Optional.ofNullable("hello")
                .filter(s -> s.startsWith("h")) // This will filter the Optional to only include the value if it starts with 'h'
                .ifPresent(System.out::println); // This will print "hello" if the Optional is present and matches the filter condition
    }
}
