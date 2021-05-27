package cn.vorbote.commons.except;

public class NumberOutFieldsException extends RuntimeException {
    public NumberOutFieldsException() {
    }

    public NumberOutFieldsException(String message) {
        super(message);
    }
}
