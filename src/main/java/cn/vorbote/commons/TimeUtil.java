package cn.vorbote.commons;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TimeUtil can transfer unix/java timestamps to Date object.
 *
 * @author TheodoreHills
 */
@Slf4j
public final class TimeUtil {

    private TimeUtil() {

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

    /**
     * Create a date instance by {@code calendar}.
     *
     * @param year  The year num such as 2021.
     * @param month The month num such as {@code Calendar.JANUARY}
     * @param date  The date in that month.
     * @return The date instance created by the specified date.
     */
    public static Date GetDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }

    /**
     * Create a date instance by {@code calendar}.
     *
     * @param calendar The calendar instance.
     * @return The date instance created by the specified date.
     */
    public static Date GetDate(Calendar calendar) {
        return calendar.getTime();
    }

    /**
     * Get the calendar instance by a date instance.
     *
     * @param date The date instance.
     * @return The calendar instance.
     */
    public static Calendar GetCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * Get the current timestamp.
     *
     * @return The current timestamp.
     */
    private static long javaTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * Get the current timestamp.
     *
     * @return The current timestamp.
     */
    private static long unixTimestamp() {
        return javaTimestamp() / 1000;
    }

    /**
     * Get the timestamp.
     *
     * @param isUnixTimestamp If you need unit timestamp, then put a true in it.
     * @return The timestamp in specific format.
     */
    public static long Now(boolean isUnixTimestamp) {
        return isUnixTimestamp ? unixTimestamp() : javaTimestamp();
    }
}
