package com.core.functional.program;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class A2_ObjectLevelSteam {

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
