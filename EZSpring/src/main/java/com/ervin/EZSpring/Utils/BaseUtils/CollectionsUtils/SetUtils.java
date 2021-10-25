package com.ervin.EZSpring.Utils.BaseUtils.CollectionsUtils;

public class SetUtils {
    static String getSetAPI(){
        return
            """
                HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
                TreeSet是有序的，因为它实现了SortedSet接口。
                将元素添加进Set<E>：boolean add(E e)
                将元素从Set<E>删除：boolean remove(Object e)
                判断是否包含元素：boolean contains(Object e)
            """;
    }
}
