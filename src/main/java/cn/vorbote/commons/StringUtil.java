package cn.vorbote.commons;

/**
 * This is the string util
 * @author vorbote
 * @since 0.0.1.PRE
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param val 需要判断的字符串
     * @return 若字符串为空，返回true，否则返回false
     */
    public static boolean IsEmpty(String val) {
        return val == null || val.length() == 0;
    }

    /**
     * 判断字符串是否不为空
     * @param val 需要判断的字符串
     * @return 若字符串不为空，返回true，否则返回false
     */
    public static boolean IsNotEmpty(String val) {
        return !IsEmpty(val);
    }

    /**
     * 判断字符串是否不为空白
     * @param val 需要判断的字符串
     * @return 若字符串为空白，则返回为true，否则返回false
     */
    public static boolean IsBlank(String val) {
        return val.isBlank();
    }

}
