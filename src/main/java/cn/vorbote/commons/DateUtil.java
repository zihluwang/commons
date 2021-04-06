package cn.vorbote.commons;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateUtil can transfer unix/java timestamps to Date object.
 *
 * @author TheodoreHills
 */
@Slf4j
public final class DateUtil {

    private DateUtil() {

    }

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd hh:mm:ss";

    // Java Timestamp
    public static final String JAVA_TIMESTAMP = "\\d{13}";
    // Unix Timestamp
    public static final String UNIX_TIMESTAMP = "\\d{10}";

    /**
     * Transfer timestamp to class java.util.Date
     *
     * @param strDate timestamp
     * @return The Date object if succeed, current date if failed
     */
    public static Date TimestampToDate(String strDate) {
        log.debug(String.format("Transferring [%s] to Date object.", strDate));
        if (strDate.matches(UNIX_TIMESTAMP)) {
            return new Date(Long.parseLong(strDate) * 1000);
        } else if (strDate.matches(JAVA_TIMESTAMP)) {
            return new Date(Long.parseLong(strDate));
        }
        return new Date();
    }

    /**
     * Transfer Date to String
     *
     * @param date    Date object
     * @param pattern The pattern of the string
     * @return Converted String
     */
    public static String DateToString(Date date, String pattern) {
        if (StringUtil.IsBlank(pattern)) {
            log.debug("Passed a null value of parameter pattern, using the DEFAULT pattern.");
            pattern = DEFAULT_PATTERN;
        }
        log.debug(String.format("Transferring date object to String as the pattern of %s", pattern));
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        return dateFormatter.format(date);
    }
}
