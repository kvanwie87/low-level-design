package solid;

public class LiskovSubsitutionPrinciple {
    class Animal {
        public void makeSound() {
            System.out.println("Animal sound");
        }
    }
    class GoodAnimal extends Animal {
        @Override
        public void makeSound() {
            System.out.println("GoodAnimal sound");
        }
    }
    class BadAnimal extends Animal {
        @Override
        public void makeSound() {
            throw new UnsupportedOperationException("BadAnimal cannot make sound");
        }
    }

    class Maths {
        public int add(int a, int b) {
            return a + b;
        }
    }
    class BadMaths extends Maths {
        @Override
        public int add(int a, int b) {
            if(a < 0 || b < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed");
            }
            return super.add(a, b);
        }
    }
    class GoodMaths extends Maths {
        @Override
        public int add(int a, int b) {
            return 1; // Technically this is still substitutable because you are allowed to "shrink" the range of output
        }
    }
}
