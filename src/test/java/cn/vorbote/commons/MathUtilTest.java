package cn.vorbote.commons;

import cn.vorbote.commons.utils.MathUtil;
import org.junit.Test;

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
        String s = MathUtil.ToBinaryString(10);
        System.out.println(s);
    }
}