package Enum;

public class EnumMain {
    public static void main(String[] args) {
        String s = Weekday.SUN.name(); // "SUN"
        int n = Weekday.MON.ordinal(); // 1

        Weekday day = Weekday.SUN;
        // 仅一个实例可以用==比较
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}