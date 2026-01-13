package functionalinterfaces;

import java.util.function.Function;

public class FunctionExamples {
    // Function notes
    // It represents a function that takes in one argument of type T and produces a result of type R
    // It has a single abstract method apply(T t)
    // It is often used for transformations, mappings, or any operation that takes an input and produces an output

    // As "any operation that takes an input and produces an output" implies, Function can be used for a wide variety of tasks

    // Example of a transformation from one class to another using Function
    Function<Person, PersonDTO> personToDTOFunction = (Person person) -> {
        PersonDTO dto = new PersonDTO();
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        return dto;
    };

    class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class PersonDTO {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    // Example of a Function being used with Java Streams to transform a list of Persons to PersonDTOs
    // Java Streams API makes extensive use of Function for mapping operations and is the most common use case
    public void transformPersonList(java.util.List<Person> persons) {
        java.util.List<PersonDTO> dtos = persons.stream()
                .map(personToDTOFunction) // Using the Function to transform each Person to PersonDTO
                .toList();
        dtos.forEach(dto -> System.out.println("DTO Name: " + dto.getName() + ", Age: " + dto.getAge()));
    }

    // Function has default methods andThen and compose for function composition
    public void functionCompositionExample() {
        Function<Integer, Integer> multiplyBy2 = (Integer x) -> x * 2;
        Function<Integer, Integer> add3 = (Integer x) -> x + 3;

        // Using andThen: first multiply by 2, then add 3
        Function<Integer, Integer> multiplyThenAdd = multiplyBy2.andThen(add3);
        System.out.println("Result of multiplyThenAdd(5): " + multiplyThenAdd.apply(5)); // Output: 13

        // Using compose: first add 3, then multiply by 2
        Function<Integer, Integer> addThenMultiply = multiplyBy2.compose(add3);
        System.out.println("Result of addThenMultiply(5): " + addThenMultiply.apply(5)); // Output: 16
    }


}
