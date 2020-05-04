package com.core.functional.concept;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        int numbers[] = {1, 3, 9, 3, 4, 5, 6, 7, 0, 2};
        //IntStream.of(numbers).sorted().distinct().forEach(System.out::println);

        List<User> userList = Arrays.asList(new User[]{
                new User(3, "John"),
                new User(1,"sunil"),
                new User(2,"Ramesh"),
                new User(5,"Alan")
        });
        userList.stream()
                .distinct()
                .map(User::setProfile)
                //.filter(e -> e.getId() > 2)
                .sorted(ComparatorUtil.comparingInt((u)->u.getId()))
                //.allMatch(e->true)
                .forEach(System.out::println);

    }
}

class User{
    private int id;
    private String name;
    private String display;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static User setProfile(User user){
        user.setDisplay(user.getId() + " : " + user.getName());
        return user;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
