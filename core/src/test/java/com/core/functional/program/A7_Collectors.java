package com.core.functional.program;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sunsingh
 */
public class A7_Collectors {

    ArrayList<Employee> list;

    @BeforeEach
    public void before() {
        list = new ArrayList<>();
        list.add(new Employee(1, "John", "Admin"));
        list.add(new Employee(2, "David", "Manager"));
        list.add(new Employee(3, "Kim", "Admin"));
        list.add(new Employee(4, "Drew", "Admin"));
    }

    @Test
    public void groupingBy() {
        Map<String, Set<Employee>> map = list
                .stream()
                .collect(Collectors.groupingBy(Employee::getRole, Collectors.toSet()));
        System.out.println(map);
    }

    @Test
    public void collectAsList() {
        List<Employee> l = list
                .stream()
                .filter(e -> e.getRole().equals("Admin"))
                .collect(Collectors.toList());
        System.out.println(l);
    }

    class Employee {

        private int id;
        private String name;
        private String role;

        public Employee(int id, String name, String role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getRole() {
            return role;
        }

        @Override
        public String toString() {
            return "Employee{" + "id=" + id + ", name=" + name + ", role=" + role + '}';
        }

    }

}
