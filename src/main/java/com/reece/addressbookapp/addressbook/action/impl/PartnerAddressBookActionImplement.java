package com.reece.addressbookapp.addressbook.action.impl;


import com.reece.addressbookapp.addressbook.model.AddressBook;
import com.reece.addressbookapp.addressbook.model.PartnerAddressBook;

public class PartnerAddressBookActionImplement  extends AddressBookActionImplement{

    public AddressBook createAddressBook(String addressBookName) {
        return new PartnerAddressBook(addressBookName);
    }

}
