package cn.vorbote.commons.except;

/**
 * This exception means that the count of your given args doesn't match
 * the count of the wild cards.
 *
 * @author vorbote thills@vorbote.cn
 * @since 1.5.1
 */
public class ArgsCountDontMatchException extends RuntimeException {

    public ArgsCountDontMatchException() {
    }

    public ArgsCountDontMatchException(String message) {
        super(message);
    }
}
