package cn.vorbote.commons;

import javax.crypto.*;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * This tool class can convert String to Base64-String or MD5-String
 * @author TheodoreHills
 */
public class SecurityUtil {

    private static final int KEY_SIZE = 128;
    private static final String ALGORITHM = "AES";
    private static final String RNG_ALGORITHM = "SHA1PRNG";

    /**
     * Encrypt the string via MD5
     * <hr>
     * <p><b><i>Be advised: You will not able to recover this encrypted String</i></b></p>
     * @param value The string will be encrypted
     * @return The encrypted String
     */
    public static String Md5Encrypt(String value) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            md.update(value.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest();
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                String str = Integer.toHexString(b & 0xff);
                if (str.length() == 1) {
                    builder.append("0");
                }
                builder.append(str);
            }
            result = builder.toString();
            // It will get no exception, so ignore it
        } catch (NoSuchAlgorithmException ignored) { }
        return result;
    }

    /**
     * Encrypt the string via Base64
     *
     * @param value The string will be encrypted
     * @return The encrypted String
     */
    public static String Base64Encode(String value) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedString = encoder.encode(value.getBytes(StandardCharsets.UTF_8));

        return new String(encodedString);
    }

    /**
     * Decode the string via Base64
     *
     * @param value The string will be encrypted
     * @return The encrypted String
     */
    public static String Base64Decode(String value) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedString = decoder.decode(value.getBytes(StandardCharsets.UTF_8));

        return new String(decodedString);
    }

}
