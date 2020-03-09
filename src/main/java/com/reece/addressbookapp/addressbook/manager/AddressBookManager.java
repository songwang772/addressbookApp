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

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressBookManager {
    public Map<String, AddressBook> addressBookMap;

    private boolean isValidContact() {
        return true;
    }

    /**
     * Add contact
     *
     * @param contractName
     * @param phoneNumber
     * @param type
     * @param addressBookName
     * @return
     * @throws AddressBookNotValidException
     */
    public boolean addContact(String contractName, String phoneNumber, String type, String addressBookName) throws AddressBookNotValidException {
        //create or find address book
        AddressBook addressBook = addAddressBookByName(addressBookName, type);

        //create contact
        //add contact to address book
        addressBook.getContactList().add(new Contact(contractName, phoneNumber));
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
    public List<Contact> getAllContractInAddressBook(String addressBook) throws AddressBookNotValidException {
        return getAllContractInAddressBook(getAddressBookByName(addressBook));
    }

    private List<Contact> getAllContractInAddressBook(AddressBook addressBook) {
        return addressBook.getContactList();
    }

    /**
     * Get all unique contact in all of address books
     *
     * @param addressBook
     * @return
     */
    public Set<Contact> getContractInAllAddressBook() {
        Set<Contact> allUniqueContacts = new HashSet<Contact>();
        for (Map.Entry<String, AddressBook> entry : addressBookMap.entrySet()) {
            AddressBook item = entry.getValue();
            allUniqueContacts.addAll(item.getContactList());
        }
        return allUniqueContacts;
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