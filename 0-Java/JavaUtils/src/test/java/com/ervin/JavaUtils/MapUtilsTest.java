package com.ervin.JavaUtils;

import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsTest {
    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        System.out.println(MapUtils.isEmpty(map));
        System.out.println(MapUtils.isNotEmpty(map));
        // 取值并转为integer
        System.out.println(MapUtils.getInteger(map,"a"));
    }
}
