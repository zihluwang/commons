package cn.vorbote.test;

import cn.vorbote.commons.ShellUtil;
import org.junit.Test;

public class TestShellUtil {

    @Test
    public void run01() {
        String command = "whoami";
        ShellUtil.RunShell(command);

        // command = "echo ";
        String path = System.getenv("PATH");
        // ShellUtil.RunShell(command);
        System.out.println(path);
    }
}
