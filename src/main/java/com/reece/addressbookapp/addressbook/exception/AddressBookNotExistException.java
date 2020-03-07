package com.reece.addressbookapp.addressbook.exception;


import com.reece.addressbookapp.common.exception.BaseException;

public class AddressBookNotExistException extends BaseException {


    public AddressBookNotExistException() {
    }

    public AddressBookNotExistException(String message) {
        super(message);
    }

    public AddressBookNotExistException(Throwable cause) {
        super(cause);
    }

    public AddressBookNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
