package com.core.functional.concept;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A4_GroupingSteam {

    @Test
    public void simpleGrouping(){
        List<User> userList = CommonUtil.getUserList();
        Stream<User> stream = userList.stream();
        stream.collect(Collectors.groupingBy(user -> user.getRole()))
//        stream.collect(Collectors.groupingBy(User::getRole))
                .forEach((k, v) -> {
                    System.out.println("-------");
                    System.out.println(k);
                    System.out.println(v);
                });
    }

    @Test
    public void complexGrouping(){
        List<User> userList = CommonUtil.getUserList();
        Stream<User> stream = userList.stream();
        stream.collect(Collectors.groupingBy(user -> user.getRole() + user.getName()))
                .forEach((k, v) -> {
                    System.out.println("-------");
                    System.out.println(k);
                    System.out.println(v);
                });
    }

    @Test
    public void modifyMapValueType(){
        List<User> userList = CommonUtil.getUserList();
        Stream<User> stream = userList.stream();
        //Let's use the toSet() collector as the downstream collector and get a Set of blog posts (instead of a List):
        stream.collect(Collectors.groupingBy(user -> user.getRole(), Collectors.toSet()))
                .forEach((k, v) -> {
                    System.out.println("-------");
                    System.out.println(k);
                    System.out.println(v);
                });
    }

    @Test
    public void nestedGrouping(){
        List<User> userList = CommonUtil.getUserList();
        Stream<User> stream = userList.stream();
        //Let's use the toSet() collector as the downstream collector and get a Set of blog posts (instead of a List):
        stream.collect(Collectors.groupingBy(user -> user.getRole(), Collectors.groupingBy(User::getName)))
                .forEach((k, v) -> {
                    System.out.println("-------");
                    System.out.println(k);
                    System.out.println(v);
                });
    }
}
