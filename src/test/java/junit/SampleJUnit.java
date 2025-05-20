package junit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // This annotation is used to enable Mockito annotations in JUnit 5
public class SampleJUnit {
    /***
     General Steps to Create a JUnit Test Case
     1. Create mock objects for the dependencies of the class you are testing.
     2. Create an instance of the class you are testing.
     3. Inject the mock objects into the class you are testing.
     4. Create input data for the method you are testing.
     5. Invoke the method you are testing using the input data.
     6. Verify the output of the method you are testing.
     7. Optional: Perform verifications on the mock objects to ensure that the expected methods were called with the expected arguments.
     ***/

    @Mock
    private DependencyOfThingToTest1 dependency1; // This is a mock object of the class that is a dependency of the class you are testing
    @Mock
    private DependencyOfThingToTest2 dependency2; // This is a mock object of the class that is a dependency of the class you are testing

    @Test
    public void shouldTestSomething() {
        ThingToTest thingToTest = new ThingToTest(dependency1, dependency2); // This is the class you are testing, and you are injecting the mock objects into it
        InputClass inputForTest = new InputClass(1); // This is the input data for the method you are testing, it can be real data or mock data
        MyResultClass result = thingToTest.someFunctionality(inputForTest); // This is the method you are testing, and you are invoking it with the input data
        assertEquals(1, result.getResult()); // This is the verification step, you are checking if the output of the method is what you expect
    }

    @Test
    public void shouldTestSomethingMoreComplicated() {
        ThingToTest thingToTest = new ThingToTest(dependency1, dependency2);
        InputClass inputForTest = new InputClass(1);
        // The mock is not real so you have to tell it what to return when the method is called
        //when(dependency1.someFunctionality(inputForTest)).thenReturn(2); // This is where you are mocking the behavior of the dependency
        when(dependency2.someHelperFunctionality(inputForTest)).thenReturn(3); // This is where you are mocking the behavior of the dependency
        when(dependency1.someFunctionality(any())).thenReturn(2); // There is different ways to match the input to the method, any is one of the available ArgumentMatchers
        MyResultClass result =  thingToTest.someFunctionalityMoreComplicated(inputForTest);
        assertEquals(5, result.getResult()); // This is the verification step, you are checking if the output of the method is what you expect
        // You can also verify that the method was called on the mock. This validates behavior of the method instead of the result and can be useful for some tests.
        verify(dependency1).someFunctionality(inputForTest); // This is where you are verifying that the method was called on the dependency
        // There is many different jupiter assertions and mockito verifications you can use
    }


    class ThingToTest {
        private DependencyOfThingToTest1 dependency1;
        private DependencyOfThingToTest2 dependency2;
        public ThingToTest(DependencyOfThingToTest1 dependency1, DependencyOfThingToTest2 dependency2) {
            this.dependency1 = dependency1;
            this.dependency2 = dependency2;
        }

        public MyResultClass someFunctionality(InputClass input) {
            return new MyResultClass(1);
        }
        public MyResultClass someFunctionalityMoreComplicated(InputClass input) {
            int resultPart1 = dependency1.someFunctionality(input);
            int resultPart2 = dependency2.someHelperFunctionality(input);
            return new MyResultClass(resultPart1+resultPart2);
        }
    }

    class DependencyOfThingToTest1 {
        // Potentially many dependencies not relevant to the test
        FakeDAO fakeDAO;
        public int someFunctionality(InputClass input) {
            // Potentionally complex logic that is not relevant to the test
            return fakeDAO.getData(input);
        }
    }
    class DependencyOfThingToTest2 {
        FakeDAO fakeDAO;
        public int someHelperFunctionality(InputClass input) {
            return fakeDAO.getData(input);
        }
    }
    class FakeDAO {
        public int getData(InputClass input) {
            return 1;
        }
    }
    class InputClass {
        private int input;
        public InputClass(int input) {
            this.input = input;
        }
        public int getInput() {
            return input;
        }
    }

    class MyResultClass {
        private int result;
        public MyResultClass(int result) {
            this.result = result;
        }
        public int getResult() {
            return result;
        }
    }
}
