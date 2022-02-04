package Enum;

public class EnumMain2 {
    public static void main(String[] args) {
        Weekday2 day = Weekday2.SUN;
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Today is " + day + ". Work at home!");
        } else {
            System.out.println("Today is " + day + ". Work at office!");
        }
    }
}

enum Weekday2 {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    // 字段final
    public final int dayValue;
    private final String chinese;
    // 构造方法private
    private Weekday2(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }
    // name不能重写，toString可以
    @Override
    public String toString() {
        return this.chinese;
    }
}