package com.core.functional.program;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A3_WithComparatorSteam {

    @Test
    public void withComparatorSteam() {

        List<User> userList = CommonUtil.getUserList();

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> comparator2 = (o1, o2) -> o1 - o2;

        ToIntFunction<User> toIntFunction = new ToIntFunction<User>() {
            @Override
            public int applyAsInt(User user) {
                return user.getId();
            }
        };

        ToIntFunction<User> toIntFunction2 = User::getId;

        ToIntFunction<User> toIntFunction3 = User::getId;

        Stream<User> stream = userList.stream();
        stream.sorted(CommonUtil.comparingInt(toIntFunction3))
              .forEach(System.out::println);

    }
}
