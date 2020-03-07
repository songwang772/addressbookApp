package com.reece.addressbookapp.addressbook.model;


import com.reece.addressbookapp.contact.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CustomerAddressBook extends AddressBook {

    List<Contact> list = new ArrayList<Contact>();

    public CustomerAddressBook(String name) {
        super(name);
    }

}
