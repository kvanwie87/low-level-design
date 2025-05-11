package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams_Part1_TypesAndCreation {
    public static class SomeClass {

    }
    public static void main(String[] args) {
        /*** There is two main types of streams in Java: ***/
        // 1. Primitive streams (IntStream, LongStream, DoubleStream)
        // 2. Object streams (Stream<T>)
        // Primitive streams are specialized for handling primitive types that are not boxed into their wrapper classes (e.g. int, long, double)
        // Object streams are used for handling objects of any type (e.g. String, Integer, etc.)

        /*** Common ways to create primitive streams: ***/
        // 1. Using the static methods of the IntStream, LongStream, and DoubleStream classes
        IntStream intStream1 = IntStream.of(1,2,3,4,5);
        IntStream intStream2 = IntStream.range(1, 6); // 1 to 5
        IntStream intStream3 = IntStream.rangeClosed(1, 5); // 1 to 5 inclusive
        IntStream intStream4 = IntStream.iterate(1, n -> n + 1).limit(5); // iterate takes in a seed and a function to generate the next element. It is essentially an infinite stream
        IntStream intStream5 = IntStream.generate(() -> 1).limit(5); // generate takes in a supplier and generates an infinite stream using that supplier. This is also an infinite stream
        // 2. Using the static methods of the Arrays class
        Arrays.stream(new int[]{1,2,3,4,5}); // This creates a stream from an array of primitives. Overloaded for all primitive types
        // 3. Converting an Integer Stream to an IntStream
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        IntStream intStream6 = integerStream.mapToInt(Integer::intValue); // This converts the Integer stream to an IntStream using the mapToInt method

        // Some classes return primitive streams.
        IntStream chars = "Hello".chars(); // String.chars() returns an IntStream of the characters in the string
        new Random().ints(5); // Random.ints() returns an IntStream of random integers


        /*** Common ways to create object streams: ***/
        // 1. Converting a collection to a stream. THIS IS THE MOST COMMON WAY TO CREATE A STREAM
        List<String> someList = Arrays.asList("a", "b", "c");
        someList.stream(); // This creates a stream from a collection.
        // Any type that implements the Collection interface can be converted to a stream using the stream() method

        // 2. Using the static methods of the Stream class
        Stream<String> stringStream1 = Stream.of("a", "b", "c");
        Stream<String> stringStream2 = Stream.of(new String[]{"a", "b", "c"}); // This creates a stream from an array of objects
        Stream.generate(() -> "a").limit(5); // This creates an infinite stream of "a" using the generate method
        Stream.iterate("a", s -> s + "a").limit(5); // This creates an infinite stream of "a", "aa", "aaa", "aaaa", "aaaaa" using the iterate method
        Stream.builder() // This creates a stream builder that can be used to build a stream
                .add("a")
                .add("b")
                .add("c")
                .build(); // This builds the stream from the builder
        // 3. Using the static methods of the Arrays class
        Arrays.stream(new String[]{"a", "b", "c"}); // This creates a stream from an array of objects
        Arrays.stream(new String[]{"a", "b", "c"}, 0, 2); // This creates a stream from a subarray of objects
        // 4. Converting a primitive stream to an object stream
        IntStream.of(1,2,3).mapToObj(Integer::toString); // This converts an IntStream to a Stream<String> using the mapToObj method


    }

}
