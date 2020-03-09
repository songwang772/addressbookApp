package com.reece.addressbookapp.addressbook.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import com.reece.addressbookapp.addressbook.exception.AddressBookNotValidException;
import com.reece.addressbookapp.contact.model.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

class AddressBookManagerTest {

    private AddressBookManager manager;

    /**
     * A set up before the execution of each test.
     * @throws Exception
     */
    @Before
    public void before() throws Exception {
        manager = new AddressBookManager();
//CUSTOMER, EMPLOYEE, PARTNER
        manager.addContact("test1", "000","CUSTOMER","customer");
        manager.addContact("test2", "111","CUSTOMER", "customer");


        manager.addContact("test3", "000","PARTNER","partner");
        manager.addContact("test4", "111","PARTNER", "partner");


        manager.addContact("test5", "000","EMPLOYEE","work");
        manager.addContact("test6", "111","EMPLOYEE", "work");

    }

    /**
     * Acceptance criteria #1: Users should be able to add new contact entries
     */
    @Test
    public void addContactTest() {

        try {
            manager.addContact("test", "000","customer","customer");
        } catch (AddressBookNotValidException e) {
            e.printStackTrace();
        }

        assertTrue(manager.getContractInAllAddressBook().contains(new Contact("test","000")));
        assertTrue(false);
    }

    /**
     * Acceptance criteria #2: Users should be able to remove existing contact entries
     */
    @Test
    public void removeContactTest() {
        try {
            manager.removeContact(new Contact("test","000"),"customer");
        } catch (AddressBookNotValidException e) {
            e.printStackTrace();
        }

        Set<Contact> contacts = manager.getContractInAllAddressBook();
        assertFalse(contacts.contains(new Contact("test","000")));
    }

    /**
     * Acceptance criteria #3: Users should be able to print all contacts in an address book
     */
    @Test
    public void getContactsInAdressBookTest() throws AddressBookNotValidException {

        List<Contact> customer = manager.getAllContractInAddressBook("customer");
        assertTrue(customer.contains(new Contact("test1","000")));
        assertTrue(customer.contains(new Contact("test1","111")));

        List<Contact> partner = manager.getAllContractInAddressBook("partner");
        assertTrue(partner.contains(new Contact("test3","000")));
        assertTrue(partner.contains(new Contact("test4","222")));


        List<Contact> work = manager.getAllContractInAddressBook("work");
        assertTrue(work.contains(new Contact("test5","000")));
        assertTrue(work.contains(new Contact("test6","333")));

    }

    /**
     * Acceptance criteria #4: Users should be able to maintain multiple address books
     */
//    @Test
//    public void maintainMultipleAddressBooksTest() {
//
//    }

    /**
     * Acceptance criteria #5: Users should be able to print a unique set of all
     * contacts across multiple address books
     */
//    @Test
//    public void uniqueContactsInAllAddressBooksTest() {
//    }

}
