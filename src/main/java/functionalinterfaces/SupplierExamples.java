package functionalinterfaces;

import java.util.function.Supplier;

public class SupplierExamples {
    // Supplier notes
    // It represents a function which does not take in any argument but produces a value of type T
    // It has a single abstract method get()
    // It is often used for lazy evaluation, deferred execution, or when you want to generate values on demand

    // Basic example of a Supplier<String> using a lambda expression
    // It takes in no arguments and returns a hardcoded string "Hello, World!"
    Supplier<String> stringSupplier = () -> "Hello, World!";

    // A method that takes in a Supplier and uses it
    public void someMethodThatTakesInASupplier(Supplier<String> supplier) {
        // Using the supplier to get the value
        String value = supplier.get();
        System.out.println("Value from supplier: " + value);
    }

    // Java Optional class makes use of Supplier in several methods
    // Example of supplier used with Optional
    public void optionalExample() {
        java.util.Optional<String> optionalValue = java.util.Optional.of("Optional Value");
        String value = optionalValue.orElseGet(() -> "Default Value"); // The supplier is only invoked if optional is empty as a way to get a default value
        /*
        Implementation of orElseGet:
            public T orElseGet(Supplier<? extends T> supplier) {
                return value != null ? value : supplier.get();
            }
         */
        System.out.println("Value from optional: " + value);


        optionalValue.orElseThrow(() -> new IllegalArgumentException("Value not present")); // Supplier used to create exception if value is absent
        /*
        Implementation of orElseThrow:
            public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
                if (value != null) {
                    return value;
                } else {
                    throw exceptionSupplier.get();
                }
            }
         */
    }

    // Supplier can be used as a form of dependency injection similarly to Factory pattern
    // It can also be used as a way to implement lazy loading
    public static class Service {
        private final Supplier<Dependency> dependencySupplier;

        public Service(Supplier<Dependency> dependencySupplier) {
            this.dependencySupplier = dependencySupplier; // Dependency is injected as a supplier
        }

        public void performAction() {
            Dependency dependency = dependencySupplier.get(); // Dependency is created only when needed
            dependency.action();
        }
    }

    public static class Dependency {
        public void action() {
            System.out.println("Dependency action performed.");
        }
    }


    // Supplier can also be used similar to strategy pattern providing a hook to inject different behaviors related to value generation
    public static class DoesSomethingWithValue {
        private final Supplier<Integer> valueSupplier;

        public DoesSomethingWithValue(Supplier<Integer> valueSupplier) {
            this.valueSupplier = valueSupplier;
        }

        public void execute() {
            Integer value = valueSupplier.get(); // Get the value using the supplier
            System.out.println("Value obtained: " + value);
            // Perform some operation with the value
        }
    }

    public static void main(String[] args) {
        // Here we can see different strategies for providing the value, one hardcoded and one fetching from database
        DoesSomethingWithValue example = new DoesSomethingWithValue(() -> 42); // Injecting a supplier that provides a hardcoded value
        DoesSomethingWithValue example2 = new DoesSomethingWithValue(new DatabaseRelatedValueSupplier()); // Injecting a supplier that fetches value from database
    }

    public static class DatabaseRelatedValueSupplier implements Supplier<Integer> {
        @Override
        public Integer get() {
            // Simulate fetching value from database
            System.out.println("Fetching value from database...");
            return 100; // Simulated database value
        }
    }
}
