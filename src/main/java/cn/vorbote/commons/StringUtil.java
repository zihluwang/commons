package cn.vorbote.commons;

/**
 * This is the string util
 * @author TheodoreHills
 */
public final class StringUtil {

    private StringUtil() {

    }

    /**
     * Check the string is empty
     * @param val The string you want to check
     * @return True while the string is empty, otherwise return false
     */
    public static boolean IsEmpty(String val) {
        return val == null || val.length() == 0;
    }

    /**
     * Check the string is not empty
     * @param val The string you want to check
     * @return True while the string is not empty, otherwise return false
     */
    public static boolean IsNotEmpty(String val) {
        return !IsEmpty(val);
    }

    /**
     * Check the string is blank
     * @param val The string you want to check
     * @return True while the string is blank, otherwise return false.
     *         Blank means the string is meaningless, or it only got spaces or tabs in it.
     */
    public static boolean IsBlank(String val) {
        val = val.trim();
        return IsEmpty(val);
    }

}
