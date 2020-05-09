package com.core.functional.concept;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class A3_WithComparatorSteam {

    public static void main(String[] args) {

        List<User> userList = CommonUtil.getUserList();

         Comparator<Integer> comparator = new Comparator<Integer>(){
             @Override
             public int compare(Integer o1, Integer o2) {
                 return o1 - o2;
             }
         };

        Comparator<Integer> comparator2 = (o1, o2) -> o1- o2;

        ToIntFunction<User> toIntFunction = new ToIntFunction<User>() {
            @Override
            public int applyAsInt(User user) {
                return user.getId();
            }
        };

        ToIntFunction<User> toIntFunction2 = (user) -> user.getId();

        ToIntFunction<User> toIntFunction3 = User::getId;

        Stream<User> stream = userList.stream();
                stream.sorted(CommonUtil.comparingInt(toIntFunction3))
               .forEach(System.out::println);

    }
}
