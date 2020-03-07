package com.reece.addressbookapp.addressbook.action.impl;

import com.reece.addressbookapp.addressbook.action.IAddressBookAction;
import com.reece.addressbookapp.addressbook.model.AddressBook;
import com.reece.addressbookapp.addressbook.model.CustomerAddressBook;
import com.reece.addressbookapp.contact.exception.ContactExistException;
import com.reece.addressbookapp.contact.exception.ContactNotFoundException;
import com.reece.addressbookapp.contact.model.Contact;

import java.util.Set;

public class AddressBookActionImplement implements IAddressBookAction {

    AddressBook addressBook = new CustomerAddressBook("");

    public Set<Contact> getAllContacts() {
        return (Set<Contact>) addressBook.getContactList();
    }

    public void addContact(Contact contact) throws ContactExistException {
        if (addressBook.getContactList().contains(contact)) {
            throw new ContactExistException("Contact is existed.");
        }
        addressBook.getContactList().add(contact);
    }

    public void removeContact(Contact contact) throws ContactNotFoundException {
        if (!addressBook.getContactList().contains(contact)) {
            throw new ContactNotFoundException("Contact not found.");
        }
        addressBook.getContactList().remove(contact);
    }

    public AddressBook createAddressBook(String addressBookName) {
        addressBook = new AddressBook(addressBookName);
        return addressBook;
    }
}
