import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class GenericTest {

    @Test
    public void generic(){

        Cat cat1 = new Cat();

        Factor<Cat> factory = new Factor<>();

        factory.setAnimal(cat1);

        Animal cat2 = factory.getAnimal();

        cat2.makeSound();

        List<Integer> intList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();


        addNumbers(intList);
        addNumbers(numberList);

    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1;  i <= 10; i++) {
//           Number p = list.get(0);
           list.add(i);
        }
    }

    interface Animal{
        void makeSound();
    }

    static class Cat implements Animal{
        public void makeSound(){
            System.out.println("Meo");
        }
    }

    static class Factor<T>{

        private T animal;

        public T getAnimal(){
            return animal;
        }

        public void setAnimal(T t) {
            this.animal = t;
        }
    }
}
