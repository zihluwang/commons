package cn.vorbote.commons;

import cn.vorbote.commons.except.NumberOutFieldsException;

/**
 * This is the class for transformatting rgb values.
 *
 * @author vorbote thills@vorbote.cn
 */
public final class RgbUtil {

    private RgbUtil() {
    }

    /**
     * This util can transfer a specified color to hex String.
     *
     * @param red   The red color, this value should be no less than 0,
     *              and no greater than 255.
     * @param green The red color, this value should be no less than 0,
     *              and no greater than 255.
     * @param blue  The red color, this value should be no less than 0,
     *              and no greater than 255.
     * @return The hex string.
     */
    public static String ToHex(int red, int green, int blue) {
        if (MathUtil.IsNotBetween(red, 0, 255) ||
                MathUtil.IsNotBetween(green, 0, 255) || MathUtil.IsNotBetween(blue, 0, 255) )
            throw new NumberOutFieldsException("One of the colour value is out fields.");
        return String.format("#%s%s%s",
                MathUtil.ToHexString(red, false),
                MathUtil.ToHexString(green, false),
                MathUtil.ToHexString(blue, false));
    }

}
