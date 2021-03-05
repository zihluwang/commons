package cn.vorbote.commons;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CaseUtil can transfer string to a specific pattern.
 * @author TheodoreHills
 */
@Slf4j
public class CaseUtil {
    private static final Pattern AZ_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern UNDERLINE_PATTERN = Pattern.compile("_([a-z])");

    /**
     * Transfer camel strings to underlined string
     * @param str the string will be transferred
     * @return the result
     */
    public static String Underline(String str) {
        // 正则匹配大写字符转成小写并在前面加上下划线
        log.debug(String.format("Transferring [%s] to Underline Pattern", str));
        Matcher matcher = AZ_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            // 将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            // 正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
            // 把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return Underline(sb.toString());
    }

    /**
     * Transfer underlined string to camel string
     * @param str the string will be transferred
     * @return the result
     */
    public static String LowerCamel(String str) {
        // 正则匹配下划线及后一个字符，删除下划线并将匹配的字符转成大写
        log.debug(String.format("Transferring [%s] to LowerCamel Pattern", str));
        Matcher matcher = UNDERLINE_PATTERN.matcher(str);
        StringBuffer sb = new StringBuffer(str);
        if (matcher.find()) {
            sb = new StringBuffer();
            // 将当前匹配的子串替换成指定字符串，并且将替换后的子串及之前到上次匹配的子串之后的字符串添加到StringBuffer对象中
            // 正则之前的字符和被替换的字符
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            //把之后的字符串也添加到StringBuffer对象中
            matcher.appendTail(sb);
        } else {
            return sb.toString();
        }
        return LowerCamel(sb.toString());
    }
}
