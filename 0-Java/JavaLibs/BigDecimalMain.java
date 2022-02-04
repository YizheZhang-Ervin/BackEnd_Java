import java.math.BigDecimal;
import java.math.RoundingMode;

// BigDecimal通过一个BigInteger和一个scale来表示的，即BigInteger表示一个完整的整数，而scale表示小数位数
public class BigDecimalMain {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    static void test1(){
        BigDecimal bd = new BigDecimal("123.4567");
        System.out.println(bd.multiply(bd)); // 15241.55677489
    }
    static void test2(){
        // 小数位数
        BigDecimal d1 = new BigDecimal("123.45");
        BigDecimal d2 = new BigDecimal("123.4500");
        BigDecimal d3 = new BigDecimal("1234500");
        System.out.println(d1.scale()); // 2,两位小数
        System.out.println(d2.scale()); // 4
        System.out.println(d3.scale()); // 0
    }
    static void test3(){
        // 将一个BigDecimal格式化为一个相等的，但去掉了末尾0的BigDecimal
        BigDecimal d1 = new BigDecimal("123.4500");
        BigDecimal d2 = d1.stripTrailingZeros();
        System.out.println(d1.scale()); // 4
        System.out.println(d2.scale()); // 2,因为去掉了00

        BigDecimal d3 = new BigDecimal("1234500");
        BigDecimal d4 = d3.stripTrailingZeros();
        System.out.println(d3.scale()); // 0
        System.out.println(d4.scale()); // -2
    }
    static void test4(){
        // 设置精度
        BigDecimal d1 = new BigDecimal("123.456789");
        BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // 四舍五入，123.4568
        BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // 直接截断，123.4567
        System.out.println(d2);
        System.out.println(d3);
    }
    static void test5(){
        // 求商和余数
        BigDecimal n = new BigDecimal("12.345");
        BigDecimal m = new BigDecimal("0.12");
        BigDecimal[] dr = n.divideAndRemainder(m);
        System.out.println(dr[0]); // 102
        System.out.println(dr[1]); // 0.105
    }
    static void test6(){
        // 判断两个BigDecimal是否是整数倍数
        BigDecimal n = new BigDecimal("12.75");
        BigDecimal m = new BigDecimal("0.15");
        BigDecimal[] dr = n.divideAndRemainder(m);
        if (dr[1].signum() == 0) {
            // n是m的整数倍
        }
    }
    static void test7(){
        // 使用equals()方法不但要求两个BigDecimal的值相等，还要求它们的scale()相等
        BigDecimal d1 = new BigDecimal("123.456");
        BigDecimal d2 = new BigDecimal("123.45600");
        System.out.println(d1.equals(d2)); // false,因为scale不同
        System.out.println(d1.equals(d2.stripTrailingZeros())); // true,因为d2去除尾部0后scale变为2
        System.out.println(d1.compareTo(d2)); // 0
    }
}