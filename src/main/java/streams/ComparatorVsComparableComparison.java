package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Comparable vs Comparator.
 *
 * Comparable  — defines the ONE natural ordering of a type. Implemented BY the class itself
 *               (the class "knows how to compare itself"). Single method: compareTo(other).
 *
 * Comparator  — defines an EXTERNAL ordering, separate from the class. You can have MANY of them.
 *               Used when you don't own the class, or when you need multiple orderings.
 *               Single method: compare(a, b).
 *
 * Rule of thumb:
 *   - Use Comparable for the single, default, "obvious" ordering (e.g., numbers ascending).
 *   - Use Comparator for alternative orderings or when you can't modify the class.
 */
public class ComparatorVsComparableComparison {

    public static void main(String[] args) {
        comparableExamples();
        System.out.println("--------------------------------------------------");
        comparatorExamples();
        System.out.println("--------------------------------------------------");
        contrastExamples();
    }

    // ============================================================
    // COMPARABLE — the natural ordering baked into the type
    // ============================================================
    private static void comparableExamples() {
        System.out.println("=== Comparable (natural ordering) ===");

        List<Version> versions = new ArrayList<>(Arrays.asList(
                new Version(1, 4, 0),
                new Version(1, 2, 3),
                new Version(2, 0, 0),
                new Version(1, 2, 10)
        ));

        // Because Version implements Comparable, sorting needs NO comparator argument.
        // Collections.sort uses the type's compareTo() automatically.
        Collections.sort(versions);
        System.out.println("Natural order (via compareTo): " + versions);

        // Stream.sorted() with no argument also relies on the natural ordering.
        List<Version> sorted = versions.stream().sorted().toList();
        System.out.println("Stream.sorted() no-arg:        " + sorted);

        // Comparable types can be dropped straight into sorted collections with no comparator.
        TreeSet<Version> set = new TreeSet<>(versions);
        System.out.println("TreeSet (natural order):       " + set);

        // compareTo returns negative / zero / positive.
        Version a = new Version(1, 2, 3);
        Version b = new Version(1, 3, 0);
        System.out.println("a.compareTo(b) = " + a.compareTo(b) + "  (negative means a < b)");
    }

    // ============================================================
    // COMPARATOR — external orderings you can define many of
    // ============================================================
    private static void comparatorExamples() {
        System.out.println("=== Comparator (external ordering) ===");

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("Alice", "Engineering", 95_000),
                new Employee("Bob", "Sales", 70_000),
                new Employee("Charlie", "Engineering", 80_000),
                new Employee("Dave", "Sales", 70_000)
        ));

        // Employee intentionally does NOT implement Comparable — there is no single
        // "obvious" way to order employees. Different callers want different orderings.

        Comparator<Employee> bySalary = Comparator.comparingInt(e -> e.salary);
        Comparator<Employee> byName = Comparator.comparing(e -> e.name);
        Comparator<Employee> byDeptThenSalaryDesc =
                Comparator.comparing((Employee e) -> e.department)
                          .thenComparing(Comparator.comparingInt((Employee e) -> e.salary).reversed());

        System.out.println("By salary:      " + sortedCopy(employees, bySalary));
        System.out.println("By name:        " + sortedCopy(employees, byName));
        System.out.println("By dept, salary desc: " + sortedCopy(employees, byDeptThenSalaryDesc));

        // The SAME class ordered three different ways — that's the point of Comparator.
        // With Comparable you'd be locked into exactly one ordering.

        // A sorted collection can be given an explicit comparator instead of natural ordering.
        TreeSet<Employee> byNameSet = new TreeSet<>(byName);
        byNameSet.addAll(employees);
        System.out.println("TreeSet with comparator: " + byNameSet);
    }

    // ============================================================
    // CONTRAST — using both together, and overriding natural order
    // ============================================================
    private static void contrastExamples() {
        System.out.println("=== Contrast: Comparable + Comparator together ===");

        List<Version> versions = new ArrayList<>(Arrays.asList(
                new Version(1, 4, 0),
                new Version(1, 2, 3),
                new Version(2, 0, 0)
        ));

        // Version HAS a natural ordering (ascending). But a caller can still override it
        // with a Comparator when they need something different — e.g., newest first.
        List<Version> descending = versions.stream()
                .sorted(Comparator.reverseOrder()) // reverseOrder() flips the natural (Comparable) ordering
                .toList();
        System.out.println("Natural ascending: " + versions.stream().sorted().toList());
        System.out.println("Overridden descending: " + descending);

        // Comparator.reverseOrder() and Comparator.naturalOrder() ONLY work on Comparable types,
        // because they delegate to compareTo(). Try them on a non-Comparable type and it won't compile.

        // You can also build a Comparator from the natural ordering and then extend it.
        // Here: sort Versions naturally, but that's already what compareTo does — shown for contrast.
        Comparator<Version> naturalThenIdentity = Comparator.<Version>naturalOrder();
        System.out.println("Via Comparator.naturalOrder(): " + sortedCopy(versions, naturalThenIdentity));

        // Key takeaway:
        // - Comparable answers "what is the default order for this type?"  (one answer, on the class)
        // - Comparator answers "what order do I want right now?"           (many answers, outside the class)
    }

    private static <T> List<T> sortedCopy(List<T> list, Comparator<T> comparator) {
        List<T> copy = new ArrayList<>(list);
        copy.sort(comparator);
        return copy;
    }

    // ------------------------------------------------------------
    // A type WITH a natural ordering: semantic version numbers.
    // Implementing Comparable<Version> means "Versions have one obvious order."
    // ------------------------------------------------------------
    static class Version implements Comparable<Version> {
        final int major;
        final int minor;
        final int patch;

        Version(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }

        // The single natural ordering: compare major, then minor, then patch.
        // Prefer delegating to Integer.compare over subtraction to avoid overflow.
        @Override
        public int compareTo(Version other) {
            int result = Integer.compare(this.major, other.major);
            if (result != 0) return result;
            result = Integer.compare(this.minor, other.minor);
            if (result != 0) return result;
            return Integer.compare(this.patch, other.patch);
        }

        @Override
        public String toString() {
            return major + "." + minor + "." + patch;
        }
    }

    // ------------------------------------------------------------
    // A type WITHOUT a natural ordering: there is no single obvious way to
    // order employees, so we deliberately do NOT implement Comparable.
    // Callers supply a Comparator for whatever ordering they need.
    // ------------------------------------------------------------
    static class Employee {
        final String name;
        final String department;
        final int salary;

        Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return name + "(" + department + ", $" + salary + ")";
        }
    }
}
