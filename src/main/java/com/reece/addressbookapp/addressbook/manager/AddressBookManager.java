package com.reece.addressbookapp.addressbook.manager;

import com.reece.addressbookapp.addressbook.action.IAddressBookAction;
import com.reece.addressbookapp.addressbook.action.impl.AddressBookActionImplement;
import com.reece.addressbookapp.addressbook.action.impl.CustomerAddressBookActionImplement;
import com.reece.addressbookapp.addressbook.action.impl.EmployeeAddressBookActionImplement;
import com.reece.addressbookapp.addressbook.action.impl.PartnerAddressBookActionImplement;
import com.reece.addressbookapp.addressbook.exception.AddressBookNotValidException;
import com.reece.addressbookapp.addressbook.model.AddressBookType;
import com.reece.addressbookapp.addressbook.model.AddressBook;
import com.reece.addressbookapp.contact.model.Contact;

import java.util.*;

public class AddressBookManager {
    public Map<String, AddressBook> addressBookMap;

    /**
     * Add contact
     *
     * @param contactName
     * @param phoneNumber
     * @param type
     * @param addressBookName
     * @return
     * @throws AddressBookNotValidException
     */
    public boolean addContact(String contactName, String phoneNumber, String type, String addressBookName) throws AddressBookNotValidException {
        //create or find address book
        AddressBook addressBook = addAddressBookByName(addressBookName, type);

        //create contact
        //add contact to address book
        addressBook.getContactList().add(new Contact(contactName, phoneNumber));
        return true;
    }

    /**
     * Remove contact
     *
     * @param contact
     * @param addressBookName
     * @return
     * @throws AddressBookNotValidException
     */
    public boolean removeContact(Contact contact, String addressBookName) throws AddressBookNotValidException {
        return getAddressBookByName(addressBookName).getContactList().remove(contact);
    }


    /**
     * Print out all contact in an address book
     *
     * @param addressBookName
     * @return
     * @throws AddressBookNotValidException
     */
    public String printAllContactsInAddressBook(String addressBookName) throws AddressBookNotValidException {
        List<Contact> contactList = getAddressBookByName(addressBookName).getContactList();
        StringBuffer res = new StringBuffer();
        for (Contact test : contactList) {
            res.append(test.toString());
        }
        return res.toString();
    }

    /**
     * Get all contact in a address book
     *
     * @param addressBook
     * @return
     */
    public List<Contact> getAllContactInAddressBook(String addressBook) throws AddressBookNotValidException {
        return getAllContactInAddressBook(getAddressBookByName(addressBook));
    }

    private List<Contact> getAllContactInAddressBook(AddressBook addressBook) {
        return addressBook.getContactList();
    }

    /**
     * Get all unique contact in all of address books
     *
     * @return
     */
    public Set<Contact> getUniqueContactInAllAddressBook() {
        Set<Contact> allUniqueContacts = new HashSet<Contact>();
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            AddressBook item = entry.getValue();
            allUniqueContacts.addAll(item.getContactList());
        }
        return allUniqueContacts;
    }

    /**
     * Get all addressbooks
     * @return
     */
    public List<AddressBook> getAllAddressBook() {
        List<AddressBook> res = new ArrayList<AddressBook>();
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            AddressBook item = entry.getValue();
            res.add(item);
        }
        return res;
    }

    private AddressBook addAddressBookByName(String addressBookName, String type) throws AddressBookNotValidException {
        if (addressBookName == null || addressBookName == "") {
            throw new AddressBookNotValidException("AddressBook name is not valid.");
        }
        if (addressBookMap.containsKey(addressBookName)) {
            addressBookMap.get(addressBookName);
        }
        return createAddressBook(addressBookName, type);
    }

    private AddressBook createAddressBook(String addressBookName, String type) {
        return getAddressBookInstance(type).createAddressBook(addressBookName);
    }

    private AddressBook getAddressBookByName(String addressBookName) throws AddressBookNotValidException {
        if (addressBookName == null || addressBookName == "") {
            throw new AddressBookNotValidException("AddressBook name is not valid.");
        }
        return addressBookMap.get(addressBookName);
    }

    IAddressBookAction addressBookAction;

    private IAddressBookAction getAddressBookInstance(String type) {
        if (AddressBookType.CUSTOMER.toString() == type) {
            addressBookAction = new CustomerAddressBookActionImplement();
        } else if (AddressBookType.EMPLOYEE.toString() == type) {
            addressBookAction = new EmployeeAddressBookActionImplement();
        } else if (AddressBookType.PARTNER.toString() == type) {
            addressBookAction = new PartnerAddressBookActionImplement();
        } else {
            addressBookAction = new AddressBookActionImplement();
        }
        return addressBookAction;
    }

}