package com.core.functional.concept;

import java.util.List;
import java.util.stream.Stream;

public class A2_ObjectLevelSteam {

    public static void main(String[] args) {

        List<User> userList = CommonUtil.getUserList();

        Stream<User> stream = userList.stream();
                stream.distinct()
                .sorted()
                .filter(e -> e.getId() > 2)
               .forEach(System.out::println);

    }
}
