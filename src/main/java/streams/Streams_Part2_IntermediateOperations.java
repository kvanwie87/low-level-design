package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams_Part2_IntermediateOperations {
    public static void main(String[] args) {
        // Intermediate operations are operations that return a new stream and do not modify the original stream
        // They are lazy, meaning they are not executed until a terminal operation is called on the stream
        // Examples of intermediate operations are: filter, map, flatMap, distinct, sorted, limit, skip, etc.

        Stream<String> stringStream = Stream.of("a", "b", "c");

        // filter applies a predicate to each element in the stream and returns a new stream with only the elements that match the predicate
        IntStream.range(1, 10)
                .filter(i -> i % 2 == 0) // This will filter the stream to only include even numbers
                .forEach(System.out::println);

        // map applies a function to each element in the stream and returns a new stream with the results of applying the function
        // it takes a function whose input is an element of the stream and returns a new element
        // the resulting stream will have the same number of elements as the original stream and be of the type of the return type of the function
        stringStream
                .map(s -> s + "a") // This will append "a" to each element in the stream
                .forEach(System.out::println);

        // flatMap applies a function to each element in the stream and flattens the results into a new stream
        // it takes a function whose input is an element of the stream and returns a stream
        IntStream.range(1, 10)
                .flatMap(i -> IntStream.of(i, i * 2)) // a function of Int -> IntStream that returns a stream of the number and its double
                .forEach(System.out::println);
        // If you had used map instead of flatMap, you would have ended up with a stream of streams

        stringStream
                .sorted() // This will sort the stream in natural order
                .distinct() // This will remove duplicates from the stream
                .skip(1) // This will skip the first element in the stream
                .limit(10) // This will limit the stream to 10 elements
                .forEach(System.out::println);

        // There are many other intermediate operations available in the Stream API
        // You can chain together many intermediate operations to create a complex pipeline of operations
    }
}
