package cn.vorbote.util;

// import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * This Util is made up for get ip address, the ip address
 * will only be used in the log.
 * @author vorbote
 * @since 1.1.1.RC
 */
// @Slf4j
public class IpUtil {

    private final static String LOCALHOST = "127.0.0.1";

    /**
     * Get the IP address from request
     * @param request The HTTP Request
     * @return IP address from the Request, or "" when an error occurred
     */
    public static String GetAddress(HttpServletRequest request) {
        String addr;
        try {
            addr = request.getHeader("x-forwarded-for");
            if (StringUtil.IsEmpty(addr) || "unknown".equalsIgnoreCase(addr)) {
                addr = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtil.IsEmpty(addr) || "unknown".equalsIgnoreCase(addr)) {
                addr = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtil.IsEmpty(addr) || "unknown".equalsIgnoreCase(addr)) {
                addr = request.getRemoteAddr();
                if (addr.equals(LOCALHOST)) {
                    InetAddress inet;
                    try {
                        inet = InetAddress.getLocalHost();
                        addr = inet.getHostAddress();
                    } catch (UnknownHostException e) {
                        // log.error("加载本地LOCALHOST时出现异常, Trace: {}", Arrays.toString(e.getStackTrace()));
                        System.err.printf("加载本地LOCALHOST时出现异常, Trace: [%s]\n", Arrays.toString(e.getStackTrace()));
                    }
                }
            }
            if (addr != null && addr.length() > 15) {
                if (addr.indexOf(",") > 0) {
                    addr = addr.substring(0, addr.indexOf(","));
                }
            }
        } catch (Exception e) {
            addr = "";
        }
        return addr;
    }

}
