package com.ervin.JavaUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtilsTest {
    @Test
    public void test1(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        // 判断空
        System.out.println(CollectionUtils.isEmpty(list));
        // 判断不空
        System.out.println(CollectionUtils.isNotEmpty(list));
        // 交集
        System.out.println(CollectionUtils.intersection(list,list2));
        // 并集
        System.out.println(CollectionUtils.union(list,list2));
        // 差集
        System.out.println(CollectionUtils.subtract(list,list2));
    }
}
