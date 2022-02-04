// java 14
// 不变类，除了用final修饰class以及每个字段外，编译器还自动为我们创建了构造方法，和字段名同名的方法，以及覆写toString()、equals()和hashCode()方法
//record Point(int x, int y) {
//    // Compact Constructor，它的目的是让我们编写检查逻辑
//    public Point {
//        if (x < 0 || y < 0) {
//            throw new IllegalArgumentException();
//        }
//    }
//    public static Point of() {
//        return new Point(0, 0);
//    }
//    public static Point of(int x, int y) {
//        return new Point(x, y);
//    }
//}
//
//public class RecordMain{
//    public static void main(String[] args){
//        Point z = Point.of();
//        Point p = Point.of(123, 456);
//    }
//}
