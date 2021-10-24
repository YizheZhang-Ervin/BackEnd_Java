package com.ervin.EZSpring.BasicUtils.CoreUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {
    static String getBigIntegerAPI(){
        return
            """
                new BigInteger("...")
                add()
                multiply()
                byteValue()
                shortValue()
                intValue()
                longValue()
                floatValue()
                doubleValue()
                intValueExact()
                longValueExact()
            """;
    }
    static String getBigDecimalAPI(){
        return
            """
                new BigDecimal("123.4567")
                multiply(bd)
                scale()
                stripTrailingZeros()
                setScale(精度, RoundingMode)
                divideAndRemainder()
                signum()返回函数正负号
                equals() / compareTo()
            """;
    }

}
