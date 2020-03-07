package com.reece.addressbookapp.contact.exception;

import com.reece.addressbookapp.common.exception.BaseException;

public class ContactPhoneNumberNotValidException extends BaseException {

    public ContactPhoneNumberNotValidException() {
    }

    public ContactPhoneNumberNotValidException(String message) {
        super(message);
    }

    public ContactPhoneNumberNotValidException(Throwable cause) {
        super(cause);
    }

    public ContactPhoneNumberNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
