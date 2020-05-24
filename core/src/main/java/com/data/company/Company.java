package com.data.company;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Company {
    private Integer id;
    private String name;
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
}
