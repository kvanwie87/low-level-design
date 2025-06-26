package streams;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class UsingMap {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("a", "b", "c");

        // map applies a function to each element in the stream
        // and returns a new stream with the results of applying the function

        // The function A to B where is A is the type of the elements in the original stream or one of subtypes of A
        // and B can be the same type as A or a different type

        Function<String, String> appendA = s -> s + "a"; // This is a function that appends "a" to each string
        List<String> modifiedList = stringStream
                .map(appendA) // This will apply the function to each element in the stream
                .toList(); // Collect the results into a List
        Function<String, Integer> stringLength = s -> s.length(); // This is a function that returns the length of each string
        List<Integer> modifiedList2 = stringStream.map(stringLength) // This will apply the function to each element in the stream
                .toList(); // Collect the results into a List
        //The result is a List<Integer> because the output of the provided function is Integer

        // map() can also take in lambda expressions and method references
        List<String> modifiedList3 = Stream.of("a", "b", "c")
                .map(s -> s + "b") // This is a lambda expression that appends "b" to each string
                .toList(); // Collect the results into a List
        List<String> modifiedList4 = Stream.of("a", "b", "c")
                .map(String::toUpperCase) // This is a method reference that converts each string to uppercase
                .toList(); // Collect the results into a List
        List<String> modifiedList5 = Stream.of("a", "b", "c")
                .map(UsingMap::someHelperMethod) // This is a method reference to a helper method that appends "x" to each string
                .toList(); // Collect the results into a List

        // Map can be chained with more map operations or other stream operations
        List<String> modifiedList6 = Stream.of("a", "b", "c")
                .map(s -> s + "c") // This is a lambda expression that appends "c" to each string
                .map(String::toUpperCase) // This is a method reference that converts each string to uppercase
                .map(UsingMap::someHelperMethod) // This is a method reference to a helper method that appends "x" to each string
                .toList(); // Collect the results into a List

        // Using map on Optional
        // map() on Optional is used to apply a function to the value inside the Optional if it is present
        // otherwise, it returns an empty Optional
        Optional.ofNullable("hello")
                .map(s -> s + " world") // This will apply the function to the value inside the Optional
                .ifPresent(System.out::println); // This will print "hello world" if the Optional is present

        // The main difference between map() on stream and map() on Optional is that
        // Optional may or may not value and it would only be a single value
        // whereas a stream may have many values so the function could be applied many times
    }

    public static String someHelperMethod(String s) {
        return s + "x"; // This is a helper method that appends "x" to each string
    }
}
