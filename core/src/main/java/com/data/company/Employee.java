package com.data.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Address> addressList;
    private List<Contact> contactList;

    public List<Address> getAddressList() {
        if(addressList == null){
            addressList = new ArrayList<>();
        }
        return addressList;
    }

    public List<Contact> getContactList() {
        if(contactList == null){
            contactList = new ArrayList<>();
        }
        return contactList;
    }
}

