package cn.vorbote.commons;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
public class MapUtilTest {

    private final static PrintStream fmt = System.out;

    @Test
    public void run01() {
        log.info("Hello World - {}", new Date());
    }
}