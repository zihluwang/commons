package cn.vorbote.commons;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * This Util can transfer common object to another type of object
 */
public class CastUtil {

    /**
     * Transfer a byte array to string
     * @param bytes The byte array
     * @return The string
     */
    public static String ToString(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * Convert string into bytes using UTF-8 encoding
     * @param value The string value
     * @return The bytes from the string
     */
    public static byte[] ToBytes(String value) {
        return value.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * Convert string into bytes using specified encoding
     * @param value The string value
     * @param charset The specified charset, support <code>StandardCharset.xxx</code>
     * @return The bytes from the string
     */
    public static byte[] ToBytes(String value, Charset charset) {
        return value.getBytes(charset);
    }

}
