package com.ervin.EZSpring.Utils.LibUtils.CommonsUtils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsUtils {
    // map
    static void getMapAPI(){
        Map<String,String> map = new HashMap<>();
        System.out.println(MapUtils.isEmpty(map));
        System.out.println(MapUtils.isNotEmpty(map));
        // 取值并转为integer
        System.out.println(MapUtils.getInteger(map,"a"));
    }
    // collections
    static void getCollectionsAPI(){
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
