package streams;

import java.util.List;

public class Streams_Part5_ParallelStreams {
    public static void main(String[] args) {
        /***
         * Parallel Streams
         */
        // Parallel streams are a way to process data in parallel using multiple threads
        // This can be done by calling the parallelStream() method on a collection or by calling the parallel() method on a stream
        // Parallel streams can improve performance when processing large amounts of data
        // However, they can also introduce complexity and should be used with caution
        // Parallel streams are not guaranteed to preserve the order of the elements in the stream
        // This means that the order of the elements in the output may not be the same as the order of the elements in the input
        // This is important to keep in mind when using parallel streams

        // Creating a parallel stream from a collection
        List<Integer> ints = List.of(1, 2, 3, 4, 5);
        ints.parallelStream().forEach(System.out::println);
        // Create a parallel stream from a stream
        ints.stream().parallel().forEach(System.out::println);

        // Operations that are not associative could lead to incorrect results when using parallel streams
        // For example, if you are using a reduce operation that is not associative, the result may not be what you expect
        ints.parallelStream() .reduce((a, b) -> a + b); // This is an associative operation and will work correctly with parallel streams
        ints.parallelStream().reduce((a, b) -> a - b); // This is not an associative operation and may not work correctly with parallel streams
        // Consider 1,2,3. (1-2)-3 = -4, but 1-(2-3) = 2
    }
}
