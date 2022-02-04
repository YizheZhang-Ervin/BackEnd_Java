import java.util.Set;
import java.util.TreeSet;

public class SetMain {
    public static void main(String[] args) {
//        HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
//        TreeSet是有序的，因为它实现了SortedSet接口。

//        将元素添加进Set<E>：boolean add(E e)
//        将元素从Set<E>删除：boolean remove(Object e)
//        判断是否包含元素：boolean contains(Object e)

        // 遍历
        Set<String> set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
