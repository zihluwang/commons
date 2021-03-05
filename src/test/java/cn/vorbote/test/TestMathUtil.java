package cn.vorbote.test;

import cn.vorbote.commons.MathUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestMathUtil {

    @Test
    public void testFactorial() {
        System.out.println(MathUtil.Factorial(5));
    }

    @Test
    public void testAverage() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(MathUtil.Average(integers));
    }

    @Test
    public void testSum() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println((MathUtil.Sum(integers)));
    }
}
