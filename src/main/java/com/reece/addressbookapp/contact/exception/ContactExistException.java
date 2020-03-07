package com.reece.addressbookapp.contact.exception;

import com.reece.addressbookapp.common.exception.BaseException;

public class ContactExistException extends BaseException {


    public ContactExistException() {
    }

    public ContactExistException(String message) {
        super(message);
    }

    public ContactExistException(Throwable cause) {
        super(cause);
    }

    public ContactExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
