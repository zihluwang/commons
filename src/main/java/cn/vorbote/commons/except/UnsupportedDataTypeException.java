package cn.vorbote.commons.except;

public class UnsupportedDataTypeException extends RuntimeException {
    public UnsupportedDataTypeException() {
        super();
    }

    public UnsupportedDataTypeException(String message) {
        super(message);
    }
}
