package com.reece.addressbookapp.addressbook.action.impl;

import com.reece.addressbookapp.addressbook.model.AddressBook;
import com.reece.addressbookapp.addressbook.model.CustomerAddressBook;

public class CustomerAddressBookActionImplement extends AddressBookActionImplement{

    public AddressBook createAddressBook(String addressBookName) {
        return new CustomerAddressBook(addressBookName);
    }

}
