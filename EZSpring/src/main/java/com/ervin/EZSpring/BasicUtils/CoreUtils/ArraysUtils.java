package com.ervin.EZSpring.BasicUtils.CoreUtils;

public class ArraysUtils {
    static String getArraysAPI(){
        return
            """
                dataType[] arrayRefVar = new dataType[arraySize];
                dataType[] arrayRefVar = {value0, value1, ..., valuek};
                type[][] typeName = new type[typeLength1][typeLength2];
                Arrays.binarySearch(Object[] a, Object key)
                Arrays.equals(long[] a, long[] a2)
                Arrays.fill(int[] a, int val)
                Arrays.sort(Object[] a)
                Arrays.deepToString()
                Arrays.toString()
            """;

    }
}
