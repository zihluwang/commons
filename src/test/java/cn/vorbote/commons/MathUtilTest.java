package cn.vorbote.commons;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilTest {

    @Test
    public void toHexString() {
        String str = MathUtil.ToHexString(255, false);
        System.out.println(str);
    }

    @Test
    public void toBinaryString() {
        String s = MathUtil.ToOctalString(200);
        System.out.println(s);
    }

    @Test
    public void toOctalString() {
        String s = MathUtil.ToOctalString(200);
        System.out.println(s);
    }
}