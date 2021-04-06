package cn.vorbote.commons;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This util class is used to run some shell commands
 * via Java
 */
@Slf4j
public final class ShellUtil {

    /**
     * You can run some shell command via this util.
     *
     * @param command The command you wanna run.
     */
    public static void RunShell(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String out = reader.readLine();
            System.out.println(out);
        } catch (IOException e) {
            // System.out.println("An IOException occurred...");
            // e.printStackTrace();
            log.error("An IOException occurred, here is the trace:");
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * This method can clear the Shell Window, but you
     * cannot clear the window in IDE
     */
    public static void ClearShell() {
        System.out.println(System.lineSeparator().repeat(50));
    }
}
