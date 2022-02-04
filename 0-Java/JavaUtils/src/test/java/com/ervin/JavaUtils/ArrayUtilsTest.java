package com.ervin.JavaUtils;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {
    @Test
    public void test1(){
        int[] ints = new int[1];
        // 打印数组内容
        System.out.println(ArrayUtils.toString(ints));
        // 数组加新值(用System.arraycopy实现)
        int[] ints2 = ArrayUtils.add(ints,7);
        // 判断数组是否为空(null/长度为0)
        System.out.println(ArrayUtils.isEmpty(ints2));
    }
}
