package cn.vorbote.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellUtil {

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
            System.out.println("An IOException occurred...");
            e.printStackTrace();
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
