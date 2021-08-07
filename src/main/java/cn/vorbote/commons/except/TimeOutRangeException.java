package cn.vorbote.commons.except;

/**
 * The developer specified date is not existed.
 *
 * @author vorbote thills@vorbote.cn
 * @since 2.0.0.RELEASE
 */
public class TimeOutRangeException extends RuntimeException {
    public TimeOutRangeException() {
    }

    public TimeOutRangeException(String message) {
        super(message);
    }
}
