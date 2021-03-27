import org.junit.Test;

public class GenericTest {

    @Test
    public void generic(){

        Cat cat1 = new Cat();

        Factor<Animal> factory = new Factor<>();

        factory.setAnimal(cat1);

        Animal cat2 = factory.getAnimal();

        cat2.makeSound();

    }

    interface Animal{
        void makeSound();
    }

    static class Cat implements Animal{
        public void makeSound(){
            System.out.println("Meo");
        }
    }

    static class Factor<T extends Animal>{

        private T animal;

        public T getAnimal(){
            return animal;
        }

        public void setAnimal(T t) {
            this.animal = t;
        }
    }
}
