package stream.h_grouping;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
            new Person("Sara", 20),
            new Person("Sara", 22),
            new Person("Bob", 20),
            new Person("Paula", 32),
            new Person("Paul", 32),
            new Person("Jack", 2),
            new Person("Jack", 72),
            new Person("Jill", 12)
        );
    }

    public static void main(String[] args) {
        example1();
        example2();
    }

    private static void example1() {
        List<Person> people = createPeople();
        Map<String, List<Person>> byName = people.stream()
            .collect(groupingBy(Person::getName));
        System.out.println(byName);
    }

    private static void example2() {
        List<Person> people = createPeople();
        Map<String, List<Integer>> nameAndAge = people.stream()
            .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
        System.out.println(nameAndAge);
    }
}
