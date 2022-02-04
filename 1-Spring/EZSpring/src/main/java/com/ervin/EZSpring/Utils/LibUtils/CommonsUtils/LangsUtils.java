package com.ervin.EZSpring.Utils.LibUtils.CommonsUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class LangsUtils {
    public static void main(String[] args) {

    }

    // string
    static void getStringAPI(){
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

    // number
    static void getNumberAPI(){
        String str="+12.3";
        // 只判断无符号整数
        System.out.println(NumberUtils.isDigits(str));
        // 可用于判断整数/浮点数，不能识别正负
        System.out.println(NumberUtils.isParsable(str));
        // 可识别整数/浮点数/正负号/进制
        System.out.println(NumberUtils.isCreatable(str));
    }

    // Object
    static void getObjectAPI(){
        String str1 = null;
        String str2 = null;
        String str3 = "123";
        // 第一个不为空的
        System.out.println(ObjectUtils.firstNonNull(str1,str2,str3));
        // 转为十六进制字符串(hashcode)
        // 调用的是System.identityHashCode(obj):不管obj所在类有没有重写hashcode方法，始终调用Object.hashCode()
        System.out.println(ObjectUtils.identityToString(str3));
    }

    // Array
    static void getArrayAPI(){
        int[] ints = new int[1];
        // 打印数组内容
        System.out.println(ArrayUtils.toString(ints));
        // 数组加新值(用System.arraycopy实现)
        int[] ints2 = ArrayUtils.add(ints,7);
        // 判断数组是否为空(null/长度为0)
        System.out.println(ArrayUtils.isEmpty(ints2));
    }
}
