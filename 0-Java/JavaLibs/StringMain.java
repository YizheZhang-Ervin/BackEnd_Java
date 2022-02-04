import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class StringMain {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 两个字符串比较，必须总是使用equals()方法。
        // 要忽略大小写比较，使用equalsIgnoreCase()方法。
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
    }

    // 字符串不可变
    static void test1(){
        String s1 = "Hello!";
        String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
        System.out.println(s1);
        s1 = s1.toUpperCase();
        System.out.println(s1);
    }

    // 字符串比较
    static void test2(){
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);  // 比较地址
        System.out.println(s1.equals(s2));  // 比较内容
    }

    static void test3(){
        // 是否包含子串:
        "Hello".contains("ll"); // true
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); //"ll"
    }

    static void test4(){
        // 去除首尾空白字符
        "  \tHello\r\n ".trim(); // "Hello"
//        "\u3000Hello\u3000".strip(); // "Hello"
//        " Hello ".stripLeading(); // "Hello "
//        " Hello ".stripTrailing(); // " Hello"
    }

    static void test5(){
        // 判断空
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
//        "  \n".isBlank(); // true，因为只包含空白字符
//        " Hello ".isBlank(); // false，因为包含非空白字符
    }

    static void test6(){
        // 替换子串
        String s = "hello";
        s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
    }

    static void test7(){
        // 分割
        String s = "A,B,C,D";
        String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
    }

    static void test8(){
        // 拼接
        String[] arr = {"A", "B", "C"};
        String s = String.join("***", arr); // "A***B***C"
    }

    static void test9(){
        // 格式化
        String s = "Hi %s, your score is %d!";
//        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }

    static void test10(){
        // 类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        Integer.getInteger("java.version"); // 版本号，11

        // 修改了char[]数组，String并不会改变
        char[] cs = "Hello".toCharArray();
        String s = new String(cs);
        System.out.println(s);
        cs[0] = 'X';
        System.out.println(s);
    }

    static void test11() throws UnsupportedEncodingException {
        // 字符编码
        byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b3 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换

        // 字节转字符串
        byte[] b = new byte[2];
        b[0] = 1;
        b[1] = 2;
        String s1 = new String(b, "GBK"); // 按GBK转换
        String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换
    }
}
