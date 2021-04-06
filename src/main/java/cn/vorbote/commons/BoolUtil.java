package cn.vorbote.commons;

/**
 * This util class is used to cast some usual data types
 * to boolean type.
 */
public final class BoolUtil {

    private BoolUtil() {
    }

    /**
     * Convert byte to boolean
     *
     * @param b The value
     * @return True while byte value is not 0
     */
    public static boolean ToBool(byte b) {
        return b != 0;
    }

    /**
     * Convert char to boolean
     *
     * @param c The value
     * @return True while char value is not 0 or '0'
     */
    public static boolean ToBool(char c) {
        return c != 0 && c != '0';
    }


    /**
     * Convert short to boolean
     *
     * @param s The value
     * @return True while short value is not 0
     */
    public static boolean ToBool(short s) {
        return s != 0;
    }

    /**
     * Convert int to boolean
     *
     * @param i The value
     * @return True while int value is not 0
     */
    public static boolean ToBool(int i) {
        return i != 0;
    }

    /**
     * Convert long to boolean
     *
     * @param l The value
     * @return True while long value is not 0
     */
    public static boolean ToBool(long l) {
        return l != 0;
    }

    /**
     * Convert float to boolean
     *
     * @param f The value
     * @return True while float value is not 0
     */
    public static boolean ToBool(float f) {
        return f != 0;
    }

    /**
     * Convert double to boolean
     *
     * @param d The value
     * @return True while double value is not 0
     */
    public static boolean ToBool(double d) {
        return d != 0;
    }

    /**
     * Convert Object to boolean
     *
     * @param obj The value
     * @return True while obj value is not null
     */
    public static boolean ToBool(Object obj) {
        return obj != null;
    }
}
