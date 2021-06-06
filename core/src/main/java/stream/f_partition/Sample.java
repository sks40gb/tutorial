package stream.f_partition;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Object o =  numbers.stream().collect(partitioningBy(x->x%2 == 0));
    System.out.println(o);
  }
}
