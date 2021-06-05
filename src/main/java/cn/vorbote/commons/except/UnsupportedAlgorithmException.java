package cn.vorbote.commons.except;

/**
 * This exception means the specified algorithm is not supported.
 *
 * @author vorbote thills@vorbote.cn
 */
public class UnsupportedAlgorithmException extends RuntimeException {
    public UnsupportedAlgorithmException() {
        super();
    }

    public UnsupportedAlgorithmException(String message) {
        super(message);
    }
}
