package com.reece.addressbookapp.addressbook.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
     * A small fixture is set up before the execution of each test.
     * @throws Exception
     */
    @Before
    public void before() throws Exception {
        manager = new AddressBookManager();
        // Add some contacts to the default address book
//        manager.addContact(new Contact("test1", "000"));

    }

    /**
     * Acceptance criteria #1: Users should be able to add new contact entries
     */
    @Test
    public void addContactTest() {

        //mock creation
//        List mockedList = mock(List.class);
//
//        //using mock object
//        mockedList.add("one");
//        mockedList.clear();
//
//        //verification
//        verify(mockedList).add("one");
//        verify(mockedList).clear();
        try {
            manager.addContact("Ambulance", "000","customer","customer");
        } catch (AddressBookNotValidException e) {
            e.printStackTrace();
        }


    }
}