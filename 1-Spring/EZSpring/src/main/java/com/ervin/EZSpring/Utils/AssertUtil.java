package com.ervin.EZSpring.Utils;

import com.ervin.EZSpring.WebEntrance.exceptions.ParamsException;

public class AssertUtil {
    public static void isTrue(Boolean flag,String msg){
        if(flag){
            throw new ParamsException(msg);
        }
    }
}