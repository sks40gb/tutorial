package stream.g_joining;

import java.util.*;
import java.util.stream.Collectors;
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
        List<Person> people = createPeople();
        String txt = people.stream()
            .map(Person::getName)
            .map(String::toUpperCase)
            .collect(joining(", "));

        System.out.println(txt);
    }
}
