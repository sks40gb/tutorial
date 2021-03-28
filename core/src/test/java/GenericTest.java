import org.junit.Test;

public class GenericTest {

    @Test
    public void generic(){

        AnimalFactory<? extends Animal> factory = new AnimalFactory<>();
        Animal cat = factory.getAnimal();
//        factory.setAnimal(new Cat());
    }

    interface Animal{
        void makeSound();
    }

    static class Cat implements Animal{
        public void makeSound(){
            System.out.println("Meo");
        }
    }

    static class AnimalFactory<T>{

        private T animal;

        public T getAnimal(){
            return animal;
        }

        public void setAnimal(T t) {
            this.animal = t;
        }
    }
}
