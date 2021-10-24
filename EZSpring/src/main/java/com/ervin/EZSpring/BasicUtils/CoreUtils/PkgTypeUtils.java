package com.ervin.EZSpring.BasicUtils.CoreUtils;

public class PkgTypeUtils {
    static String getBoxAPI(){
        return
            """
                new Integer();
                Integer.valueOf()
                intValue()
                byteValue();
                longValue();
                floatValue();
                doubleValue();
                Integer.toString(数字, 进制)
                Integer.toHexString(数字)
                Integer.toOctalString(数字)
                Integer.toBinaryString(数字) 
                Byte.toUnsignedInt()
            """;
    }

    static String getConstValAPI(){
        return
            """
                Boolean.TRUE
                Boolean.FALSE
                Integer.MAX_VALUE
                Integer.MIN_VALUE
                Long.SIZE
                Long.BYTES
            """;
    }

}
