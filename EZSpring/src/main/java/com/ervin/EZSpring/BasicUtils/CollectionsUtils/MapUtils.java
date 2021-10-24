package com.ervin.EZSpring.BasicUtils.CollectionsUtils;

import java.util.Properties;

public class MapUtils {
    static String getMapAPI(){
        return
            """
                get()
                put()
                containsKey()
                keySet()
                entrySet() / getKey() / getValue()
                hashCode()获取哈希值
            """;
    }

    static String getPropertiesAPI(){
        return
            """
                new Properties()
                load()
                getProperty()
                setProperty()
                store()
            """;
    }
}
