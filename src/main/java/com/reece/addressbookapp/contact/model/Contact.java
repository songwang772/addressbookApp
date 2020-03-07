package com.reece.addressbookapp.contact.model;

import com.reece.addressbookapp.contact.exception.ContactNameNotValidException;
import com.reece.addressbookapp.contact.exception.ContactPhoneNumberNotValidException;

import java.io.Serializable;

public class Contact implements Serializable {
    String name;
    String phoneNumber;

    public Contact(String contractName, String phoneNumber){
        this.name = contractName;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "name=" + name + ", "
                + "phoneNumber=" + phoneNumber;
    }

    public boolean nameIsValid() throws ContactNameNotValidException {
        if (this.name ==null || this.name.equals("")) {
            throw new ContactNameNotValidException("Contact name input is not valid.");
        }
        return true;
    }

    private boolean phoneNumberIsValid() throws ContactPhoneNumberNotValidException {
        String pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

        if (this.phoneNumber ==null || this.phoneNumber.equals("")) {
            throw new ContactPhoneNumberNotValidException("Phone number is blank.");
        }

        if (!this.phoneNumber.matches(pattern)) {
            throw new ContactPhoneNumberNotValidException("Phone number is not valid.");
        }
        return true;
    }

}