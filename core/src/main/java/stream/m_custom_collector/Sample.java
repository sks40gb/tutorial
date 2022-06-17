package stream.m_custom_collector;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Sample {
    public static void main(String[] args) {
        List<Person> persons = setupUsers();

        MyGroupCollector myCollector = new MyGroupCollector();
        Map<Role, List<Person>> map = persons.stream().collect(myCollector);
        System.out.println(map);
    }

    private static List<Person> setupUsers() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Alan", Role.ADMIN));
        persons.add(new Person(2, "Bob", Role.USER));
        persons.add(new Person(3, "Ally", Role.USER));
        persons.add(new Person(4, "John", Role.ADMIN));
        persons.add(new Person(5, "Jackson", Role.MANAGER));
        return persons;
    }
}

class MyGroupCollector implements Collector<Person, List<Person>, Map<Role,List<Person>>> {

    @Override
    public Supplier<List<Person>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Person>, Person> accumulator() {
        return (personList, person) -> personList.add(person);
    }

    @Override
    public BinaryOperator<List<Person>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Person>, Map<Role, List<Person>>> finisher() {
        return (list)-> {
            Map<Role, List<Person>> map = new HashMap<>();
            for(Person person : list){
                if(map.containsKey(person.getRole())){
                    map.get(person.getRole()).add(person);
                }else{
                    List<Person> newList = new ArrayList<>();
                    newList.add(person);
                    map.put(person.getRole(), newList);
                }
            }
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> set = new HashSet<>();
        set.add(Characteristics.UNORDERED);
        return set;
    }
}

@Data
@AllArgsConstructor
class Person {
    private Integer id;
    private String name;
    private Role role;
}

enum Role {
    ADMIN,
    USER,
    MANAGER
}