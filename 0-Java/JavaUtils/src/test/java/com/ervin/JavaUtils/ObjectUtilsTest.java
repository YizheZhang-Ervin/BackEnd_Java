package com.ervin.JavaUtils;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;

public class ObjectUtilsTest {
    @Test
    public void test1(){
        String str1 = null;
        String str2 = null;
        String str3 = "123";
        // 第一个不为空的
        System.out.println(ObjectUtils.firstNonNull(str1,str2,str3));
        // 转为十六进制字符串(hashcode)
        // 调用的是System.identityHashCode(obj):不管obj所在类有没有重写hashcode方法，始终调用Object.hashCode()
        System.out.println(ObjectUtils.identityToString(str3));
    }
}
