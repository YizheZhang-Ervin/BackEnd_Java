package com.ervin.JavaUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;


public class StringUtilsTest {
    @Test
    public void test1(){

        String str=" ";
        // 判断字符串是否为null/""/"  "
        System.out.println(StringUtils.isBlank(str));
        System.out.println(StringUtils.isNotBlank(str));
        // 判断字符串是否为null/""
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isNotEmpty(str));
        // 脱敏处理(中间四位换星号)
        String str2 = "12345678901";
        // 返回左边n个字符
        String left = StringUtils.left(str2,3);
        // 返回右边n个字符
        String right = StringUtils.right(str2,4);
        // 从右侧填充
        String padResult = StringUtils.rightPad(left,7,"*");
        System.out.println(padResult+right);
    }
}
