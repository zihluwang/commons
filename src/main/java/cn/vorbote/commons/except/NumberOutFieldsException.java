package cn.vorbote.commons.except;

/**
 * This exception means the number is too large or too small.
 *
 * @author vorbote thills@vorbote.cn
 */
public class NumberOutFieldsException extends RuntimeException {
    public NumberOutFieldsException() {
    }

    public NumberOutFieldsException(String message) {
        super(message);
    }
}
