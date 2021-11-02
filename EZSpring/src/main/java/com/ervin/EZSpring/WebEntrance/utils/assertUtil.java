package com.ervin.EZSpring.WebEntrance.utils;

import com.ervin.EZSpring.WebEntrance.exceptions.ParamsException;

public class assertUtil {
    public static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamsException(msg);
        }
    }
}
