package com.reece.addressbookapp.contact.exception;

import com.reece.addressbookapp.common.exception.BaseException;

public class ContactNameNotValidException extends BaseException {

    public ContactNameNotValidException() {
    }

    public ContactNameNotValidException(String message) {
        super(message);
    }

    public ContactNameNotValidException(Throwable cause) {
        super(cause);
    }

    public ContactNameNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
