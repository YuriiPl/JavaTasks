package com.home.urix.lesson4.Model;

public class LoginExistsException extends Exception {
    NoteBookRecord record;

    private LoginExistsException() {
        super();
    }

    private LoginExistsException(String message) {
        super(message);
    }

    private LoginExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    private LoginExistsException(Throwable cause) {
        super(cause);
    }

    public LoginExistsException(NoteBookRecord record) {
        super();
        this.record=record;
    }

    public NoteBookRecord getRecord() {
        return record;
    }
}
