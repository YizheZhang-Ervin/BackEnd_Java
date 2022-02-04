import java.math.BigInteger;

public class BigIntegerMain{
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("1234567890");
        System.out.println(bi.pow(5)); // 2867971860299718107233761438093672048294900000

        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780

        BigInteger i = new BigInteger("123456789000");
        System.out.println(i.longValue()); // 123456789000
        // 如果需要准确地转换成基本类型，可以使用intValueExact()、longValueExact()等方法，在转换时如果超出范围，将直接抛出ArithmeticException异常。
        System.out.println(i.multiply(i).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range
//        转换为byte：byteValue()
//        转换为short：shortValue()
//        转换为int：intValue()
//        转换为long：longValue()
//        转换为float：floatValue()
//        转换为double：doubleValue()
    }
}