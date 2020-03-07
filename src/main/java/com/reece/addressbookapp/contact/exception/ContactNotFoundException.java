package com.reece.addressbookapp.contact.exception;

import com.reece.addressbookapp.common.exception.BaseException;

public class ContactNotFoundException extends BaseException {


    public ContactNotFoundException() {
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(Throwable cause) {
        super(cause);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
