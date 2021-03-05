package cn.vorbote.commons;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@Slf4j
public class MathUtil {

    /**
     * Calc the factorial of n
     * @param n The number N should greater or equal to 0
     * @return The result of factorial n
     * @throws RuntimeException The n should greater or equal to 0
     */
    public static long Factorial(int n) {
        if (n < 0) throw new RuntimeException("A number lower than 0 has no factorial result");
        if (n <= 1) return 1L;
        else return n * Factorial(n - 1);
    }

    public static <T extends Number> double Sum(Collection<? extends Number> numbers) {
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double Average(Collection<? extends Number> numbers) {
        double sum = Sum(numbers);
        log.debug("sum = {}, size = {}", sum, numbers.size());
        return sum / numbers.size();
    }

}
