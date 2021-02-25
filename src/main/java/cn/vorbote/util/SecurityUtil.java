package cn.vorbote.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * This tool class can convert String to Base64-String or MD5-String
 * @author vorbote
 * @since 0.0.1.PRE
 */
public class SecurityUtil {

    /**
     * 通过MD5方式加密字符串
     * <hr>
     * <p><b><i>请注意：一旦被MD5加密后无法复原，如果需要复原请使用Base64！</i></b></p>
     * @param value 待加密的字符串
     * @return 加密后的字符串
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
        } catch (NoSuchAlgorithmException ignored) { }
        return result;
    }

    /**
     * 通过Base64方式加密字符串
     * @param value 待加密的字符串
     * @return 加密后的字符串
     */
    public static String Base64Encode(String value) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedString = encoder.encode(value.getBytes(StandardCharsets.UTF_8));

        return new String(encodedString);
    }

    /**
     * 通过MD5方式加密字符串
     * <hr>
     * <p><strong>请注意：一旦被MD5加密后无法复原，如果需要复原请使用Base64！</strong></p>
     * @param value 待加密的字符串
     * @return 加密后的字符串
     */
    public static String Base64Decode(String value) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedString = decoder.decode(value.getBytes(StandardCharsets.UTF_8));

        return new String(decodedString);
    }

}
