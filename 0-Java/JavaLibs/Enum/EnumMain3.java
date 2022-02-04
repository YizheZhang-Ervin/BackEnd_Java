package Enum;

public class EnumMain3 {
    public static void main(String[] args) {
        Weekday3 day = Weekday3.SUN;
        switch(day) {
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println("Today is " + day + ". Work at office!");
                break;
            case SAT:
            case SUN:
                System.out.println("Today is " + day + ". Work at home!");
                break;
            default:
                throw new RuntimeException("cannot process " + day);
        }
    }
}

enum Weekday3 {
    MON, TUE, WED, THU, FRI, SAT, SUN;
}