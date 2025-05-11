package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams_Part4_MethodReferenceOperator {
    public static void main(String[] args) {
        /***
         * Method Reference Operator
         */
        // The method reference operator is a shorthand for a lambda expression that calls a method
        // This can be done on any method that is a static method, instance method, or constructor
        Stream.of("a", "b", "c").reduce(String::concat); // This is a shorthand for (s1, s2) -> s1.concat(s2)
        Stream.of("a", "b", "c").map(String::toUpperCase); // This is a shorthand for s -> s.toUpperCase()
        Stream.of("a", "b", "c").map(String::length); // This is a shorthand for s -> s.length()
        Stream.of("a", "b", "c").map(String::new); // This is a shorthand for s -> new String(s)
        // The method reference operator can be used to create a stream from a collection
        // This is a shorthand for the lambda expression collection -> collection.stream()
        // This is useful when you have a collection inside another collection or a collection inside an Optional
        List<List<String>> nestedCollection = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        nestedCollection.stream()
                .map(Collection::stream) // This uses the method reference operator to create a stream from each inner collection
                .forEach(innerStream -> innerStream.forEach(System.out::println)); // This will print each element in each inner stream

        // The method reference operator can be used on instances of classes as well
        Random random = new Random();
        IntStream.range(1, 10)
                .map(random::nextInt) // This is a shorthand for i -> random.nextInt(i)
                .forEach(System.out::println); // This will print a random integer between 0 and 10

        // The method reference operator can be used on this keyword and super keyword as well
        // Example of method reference operator on this keyword
        class DummyClass
        {
            public void doSomething() {
                IntStream.range(0, 10).map(this::helperMethod).forEach(System.out::println); // this is a shorthand for i -> this.helperMethod(i)
            }
            public int helperMethod(int i) {
                return i * 2;
            }
        }
        class DummyClass2 extends DummyClass
        {
            public void doSomething() {
                IntStream.range(0, 10).map(super::helperMethod).forEach(System.out::println); // this is a shorthand for i -> super.helperMethod(i)
            }
        }

        // new DummyClass().doSomething();

    }

}
