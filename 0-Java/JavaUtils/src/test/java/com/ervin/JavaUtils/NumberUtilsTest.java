package com.ervin.JavaUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

public class NumberUtilsTest {
    @Test
    public void test1(){
        String str="+12.3";
        // 只判断无符号整数
        System.out.println(NumberUtils.isDigits(str));
        // 可用于判断整数/浮点数，不能识别正负
        System.out.println(NumberUtils.isParsable(str));
        // 可识别整数/浮点数/正负号/进制
        System.out.println(NumberUtils.isCreatable(str));
    }
}
