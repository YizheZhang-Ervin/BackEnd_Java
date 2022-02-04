package com.ervin.EZSpring.Utils.BaseUtils.CoreUtils;

public class EnumUtils {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        String name = day.name();// 名称
        int ord = day.ordinal();// 顺序
        boolean compare = (day.dayValue==0); // 比较
    }
}


enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    // 字段final
    public final int dayValue;
    private final String chinese;
    // 构造方法private
    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }
    // name不能重写，toString可以
    @Override
    public String toString() {
        return this.chinese;
    }
}