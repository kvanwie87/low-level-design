package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsingComparatorLambda {
    public static void main(String[] args) {
        // A Comparator is a functional interface with a single abstract method: int compare(T o1, T o2)
        // Because it's a functional interface, we can implement it with a lambda expression.
        // Returns negative if o1 < o2, zero if equal, positive if o1 > o2.

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Eve", "Dave");

        // --- Basic lambda comparator ---
        // Sort strings by length
        Comparator<String> byLength = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        List<String> sortedByLength = names.stream()
                .sorted(byLength)
                .toList();
        System.out.println("By length: " + sortedByLength); // [Bob, Eve, Alice, Dave, Charlie]

        // --- Inline lambda in sorted() ---
        List<String> sortedAlphabetically = names.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .toList();
        System.out.println("Alphabetical: " + sortedAlphabetically);

        // --- Reverse sort with lambda ---
        List<String> sortedByLengthDesc = names.stream()
                .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())) // swap s1 and s2 for descending
                .toList();
        System.out.println("By length desc: " + sortedByLengthDesc); // [Charlie, Alice, Dave, Bob, Eve]

        // --- Comparator.comparing() with a key extractor lambda ---
        // This is the preferred way when comparing by a single property
        List<String> sortedByLengthComparing = names.stream()
                .sorted(Comparator.comparing(s -> s.length()))
                .toList();
        System.out.println("Comparing by length: " + sortedByLengthComparing);

        // --- Chaining comparators with thenComparing ---
        // Sort by length first, then alphabetically for ties
        List<String> sortedByLengthThenAlpha = names.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
        System.out.println("By length then alpha: " + sortedByLengthThenAlpha); // [Bob, Eve, Alice, Dave, Charlie]

        // --- reversed() to flip any comparator ---
        List<String> sortedByLengthReversed = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
        System.out.println("By length reversed: " + sortedByLengthReversed);

        // --- Sorting objects by a field using lambda ---
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Dave", 25)
        );

        // Sort by age ascending using a raw lambda
        List<Person> byAge = people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.age, p2.age))
                .toList();
        System.out.println("By age: " + byAge);

        // Sort by age using Comparator.comparingInt (cleaner)
        List<Person> byAgeClean = people.stream()
                .sorted(Comparator.comparingInt(p -> p.age))
                .toList();
        System.out.println("By age (comparingInt): " + byAgeClean);

        // Sort by age, then by name for ties
        List<Person> byAgeThenName = people.stream()
                .sorted(Comparator.comparingInt((Person p) -> p.age)
                        .thenComparing(p -> p.name))
                .toList();
        System.out.println("By age then name: " + byAgeThenName);

        // --- Handling nulls ---
        List<String> withNulls = Arrays.asList("banana", null, "apple", null, "cherry");

        // nullsFirst wraps another comparator and puts nulls at the beginning
        List<String> nullsFirst = withNulls.stream()
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder()))
                .toList();
        System.out.println("Nulls first: " + nullsFirst);

        // nullsLast puts nulls at the end
        List<String> nullsLast = withNulls.stream()
                .sorted(Comparator.nullsLast((s1, s2) -> s1.compareTo(s2)))
                .toList();
        System.out.println("Nulls last: " + nullsLast);

        // --- Using min() and max() with a comparator lambda ---
        String shortest = names.stream()
                .min((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse("");
        System.out.println("Shortest name: " + shortest); // Bob

        String longest = names.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest name: " + longest); // Charlie

        // --- Collections.sort() vs List.sort() vs stream().sorted() ---
        // All three accept a Comparator lambda, but they differ in mutability:

        // 1. Collections.sort() — mutates the list in place, returns void
        List<String> mutableNames = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob"));
        Collections.sort(mutableNames, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Collections.sort (in-place): " + mutableNames); // [Bob, Alice, Charlie]

        // 2. List.sort() — also mutates the list in place, returns void (added in Java 8)
        List<String> mutableNames2 = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob"));
        mutableNames2.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("List.sort (in-place): " + mutableNames2); // [Alice, Bob, Charlie]

        // 3. stream().sorted() — returns a NEW stream, original list is unchanged
        List<String> original = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sorted = original.stream()
                .sorted((s1, s2) -> s1.compareTo(s2))
                .toList();
        System.out.println("stream().sorted (new list): " + sorted); // [Alice, Bob, Charlie]
        System.out.println("Original unchanged: " + original); // [Charlie, Alice, Bob]

        // Key takeaway:
        // - Use List.sort() or Collections.sort() when you want to mutate the existing list
        // - Use stream().sorted() when you want a new sorted collection without modifying the original
        // - Collections.sort() and List.sort() require a mutable list (Arrays.asList returns fixed-size, wrap in ArrayList)
        // - stream().sorted() with no arguments uses natural ordering (the element's Comparable implementation)

        // --- Storing a comparator in a variable for reuse ---
        Comparator<Person> byNameDescThenAgeAsc = Comparator
                .comparing((Person p) -> p.name, Comparator.reverseOrder())
                .thenComparingInt(p -> p.age);

        List<Person> customSorted = people.stream()
                .sorted(byNameDescThenAgeAsc)
                .toList();
        System.out.println("Name desc then age asc: " + customSorted);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + "(" + age + ")";
        }
    }
}
