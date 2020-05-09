package com.core.functional.concept;

import java.io.Serializable;
import java.util.*;

public interface CommonUtil {

    public static List<User> getUserList(){

        List<User> userList = Arrays.asList(new User[]{
                new User(1, "John", User.Role.ADMIN),
                new User(2,"Sunil", User.Role.USER),
                new User(3,"Sunil", User.Role.USER),
                new User(4,"Rose", User.Role.USER),
                new User(5,"Nick", User.Role.MANAGER),
                new User(6,"Josh", User.Role.USER),
                new User(7,"Alan", User.Role.MANAGER)
        });
        return userList;
    }

    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }
}
