package com.core.functional.program;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A1_BasicStream {

    @Test
    public void toMap() {
        List<User> userList = CommonUtil.getUserList();
        Map<User.Role, User> map = userList
                .stream()
                .collect(Collectors.toMap(User::getRole, Function.identity(), (u1, u2) -> u1));
        System.out.println(map);

    }

    @Test
    public void toMapByGroup() {
        List<User> userList = CommonUtil.getUserList();
        Map<User.Role, List<User>> namesByCity =
                userList.stream()
                        .collect(Collectors
                                .groupingBy(User::getRole, Collectors
                                        .mapping(Function.identity(), Collectors.toList())));
        System.out.println(namesByCity);

    }

    @Test
    public void joiningByComma() {
        String position = "dev";
        String txt = Arrays.asList("11,21", "12,21", "13,23", "13,24")
                           .stream()
                           .collect(Collectors.joining(", "));
        System.out.println(txt);
    }

    @Test
    public void simpleStreamOperation(){

        Integer[] numbers = {1, 3, 9, 3, 4, 5, 6, 7, 0, 2};

        List<Integer> integerList = Arrays.asList(numbers);
//        integerList.stream()
//                .sorted()
//                .filter(n -> n >= 5)
//                .limit(2)
//                .forEach(System.out::println);

        boolean found = integerList.stream().anyMatch((i) ->i == 300);
        System.out.println(found);
    }

    @Test
    public void iterateOverObject() {

        List<User> userList = CommonUtil.getUserList();

        Stream<User> stream = userList.stream();
        stream.distinct()
              .sorted()
              .filter(e -> e.getId() > 2)
              .forEach(System.out::println);

    }

}
