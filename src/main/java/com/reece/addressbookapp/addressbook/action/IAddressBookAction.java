package com.reece.addressbookapp.addressbook.action;

import com.reece.addressbookapp.addressbook.model.AddressBook;
import com.reece.addressbookapp.contact.exception.ContactExistException;
import com.reece.addressbookapp.contact.exception.ContactNotFoundException;
import com.reece.addressbookapp.contact.model.Contact;

import java.util.Set;

public interface IAddressBookAction {

    public Set<Contact> getAllContacts();

    public void addContact(Contact contact) throws ContactExistException;

    public void removeContact(Contact contact) throws ContactNotFoundException;

    public AddressBook createAddressBook(String addressBookName);

}
