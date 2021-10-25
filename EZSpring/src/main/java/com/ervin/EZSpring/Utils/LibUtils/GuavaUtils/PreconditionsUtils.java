package com.ervin.EZSpring.Utils.LibUtils.GuavaUtils;

import com.google.common.base.Preconditions;

public class PreconditionsUtils {
    static void getPreconditionAPI(){
        // Preconditions: 校验+抛出异常
        String param = null;
         Preconditions.checkNotNull(param,"参数不能为空");
        // expression为false则抛异常
         Preconditions.checkArgument(param!=null,"参数不能为空");
    }
}
