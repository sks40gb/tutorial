package stream.b_gone_wrong;

import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Create a list of double of even numbers

    List<Integer> doubleOfEven = new ArrayList<>();
    
    numbers.stream()
      .filter(e -> e % 2 == 0)
      .map(e -> e * 2)
      .forEach(e -> doubleOfEven.add(e)); //Don't do this. Shared mutability is evil.
      //This code can't ever be executed parallel (well it will misbehave if we do).
      
    System.out.println(doubleOfEven);
  }
}
