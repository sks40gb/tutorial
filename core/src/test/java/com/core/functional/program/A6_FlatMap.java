package com.core.functional.program;

import com.data.company.Address;
import com.data.company.Company;
import com.data.company.Contact;
import com.data.company.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class A6_FlatMap {

    @Test
    public void flatMap() {
        List<Company> companies = constuctData();
        //find by street and return Employee
        companies.stream()
                 .flatMap(company -> company.getEmployeeList().stream())
                 .flatMap(employee -> {
                     Map<Employee, List<Address>> map = new HashMap<>();
                     map.put(employee, employee.getAddressList());
                     map.values().stream();
                     return employee.getAddressList().stream();
                 })
                 .forEach(out::println);
    }

    public static List<Company> constuctData() {

        List<Company> companies = new ArrayList<>();

        //Companies
        Company company1 = Company.builder().id(1).name("Apple").build();
        Company company2 = Company.builder().id(2).name("Adobe").build();
        companies.add(company1);
        companies.add(company2);

        // Employees
        Employee employee_1_1 = Employee.builder().id(1).firstName("Alan").lastName("Palmore").build();
        Employee employee_1_2 = Employee.builder().id(2).firstName("John").lastName("Doe").build();
        Employee employee_1_3 = Employee.builder().id(3).firstName("David").lastName("William").build();
        company1.getEmployeeList().add(employee_1_1);
        company1.getEmployeeList().add(employee_1_2);
        company1.getEmployeeList().add(employee_1_3);

        Employee employee_2_1 = Employee.builder().id(4).firstName("Sunil").lastName("Singh").build();
        Employee employee_2_2 = Employee.builder().id(5).firstName("Amar").lastName("Agrawal").build();
        company2.getEmployeeList().add(employee_2_1);
        company2.getEmployeeList().add(employee_2_2);

        // Addresses
        Address address_1_1_1 = Address.builder().id(1).street("Alan Street 1").country("US").build();
        Address address_1_1_2 = Address.builder().id(2).street("Alan Street 2").country("US").build();
        Address address_1_1_3 = Address.builder().id(3).street("Alan Street 3").country("US").build();
        employee_1_1.getAddressList().add(address_1_1_1);
        employee_1_1.getAddressList().add(address_1_1_2);
        employee_1_1.getAddressList().add(address_1_1_3);

        Address address_1_2_1 = Address.builder().id(4).street("John Street 4").country("US").build();
        employee_1_2.getAddressList().add(address_1_2_1);

        Address address_1_2_2 = Address.builder().id(5).street("David Street 5").country("US").build();
        employee_1_2.getAddressList().add(address_1_2_2);

        Address address_1_3_1 = Address.builder().id(6).street("David Street 2").country("US").build();
        employee_1_3.getAddressList().add(address_1_3_1);

        Address address_2_1_1 = Address.builder().id(7).street("Sunil Street 1").country("US").build();
        employee_2_1.getAddressList().add(address_2_1_1);

        Address address_2_2_1 = Address.builder().id(8).street("Amar Street 4").country("US").build();
        employee_2_2.getAddressList().add(address_2_2_1);

        //Contacts
        Contact contact_1_1_1 = Contact.builder().id(1).mobile("Alan M:11111").phone("Alan P:11111 ").build();
        Contact contact_1_1_2 = Contact.builder().id(2).mobile("Alan M:22222").phone("Alan P:22222").build();
        employee_1_1.getContactList().add(contact_1_1_1);
        employee_1_1.getContactList().add(contact_1_1_2);

        Contact contact_1_2_1 = Contact.builder().id(4).mobile("John M:44444 ").phone("John P:444444").build();
        employee_1_2.getContactList().add(contact_1_2_1);

        Contact contact_1_2_2 = Contact.builder().id(5).mobile("David M:55555").phone("David P:55555").build();
        employee_1_2.getContactList().add(contact_1_2_2);

        Contact contact_1_3_1 = Contact.builder().id(6).mobile("David M:666666").phone("David P:666666").build();
        employee_1_3.getContactList().add(contact_1_3_1);

        Contact contact_2_1_1 = Contact.builder().id(7).mobile("Sunil M:77777").phone("Sunil P:77777").build();
        employee_2_1.getContactList().add(contact_2_1_1);

        Contact contact_2_2_1 = Contact.builder().id(8).mobile("Amar M:88888").phone("Amar P:88888").build();
        employee_2_2.getContactList().add(contact_2_2_1);

        return companies;
    }


}
