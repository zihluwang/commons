package cn.vorbote.commons.except;

/**
 * This exception means the specified algorithm is not supported.
 *
 * @author vorbote thills@vorbote.cn
 * @since 1.5.5
 */
public class UnsupportedAlgorithmException extends RuntimeException {
    public UnsupportedAlgorithmException() {
        super();
    }

    public UnsupportedAlgorithmException(String message) {
        super(message);
    }
}
