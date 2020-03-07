package com.reece.addressbookapp.addressbook.exception;


import com.reece.addressbookapp.common.exception.BaseException;

public class AddressBookNotValidException extends BaseException {


    public AddressBookNotValidException() {
    }

    public AddressBookNotValidException(String message) {
        super(message);
    }

    public AddressBookNotValidException(Throwable cause) {
        super(cause);
    }

    public AddressBookNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
