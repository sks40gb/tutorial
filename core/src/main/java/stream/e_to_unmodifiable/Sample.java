package stream.e_to_unmodifiable;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Create a list of double of even numbers
    
//    List<Integer> doubleOfEven = numbers.stream()
//      .filter(e -> e % 2 == 0)
//      .map(e -> e * 2)
//      .collect(toUnmodifiableList()); //Available in latest version of jdk
//
//    System.out.println(doubleOfEven);
  }
}
