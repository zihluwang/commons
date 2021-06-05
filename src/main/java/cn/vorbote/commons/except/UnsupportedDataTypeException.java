package cn.vorbote.commons.except;

/**
 * This exception means the date type to transform is not supported.
 *
 * @author vorbote thills@vorbote.cn
 */
public class UnsupportedDataTypeException extends RuntimeException {
    public UnsupportedDataTypeException() {
        super();
    }

    public UnsupportedDataTypeException(String message) {
        super(message);
    }
}
