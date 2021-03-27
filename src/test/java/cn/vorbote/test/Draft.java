package cn.vorbote.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@SuppressWarnings("all")
@Slf4j
public class Draft {

    @Test
    public void run01() {
        calc(10);
    }

    public static double calc(int n) {
        // x - 分子，y - 分母
        double x = 2., y = 1., t;
        double sum = 0.;
        for (int i = 0; i < n - 1; i++) {
            sum += x / y;
            t = y;
            y = x;
            x += t;
            log.info("current i value: {}, current numerator: [{}], current denominator: [{}]", i, x, y);
        }
        log.info("sum = {}", sum);
        return sum;
    }
}
