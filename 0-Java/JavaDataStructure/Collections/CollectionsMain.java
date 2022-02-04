import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMain {
    public static void main(String[] args) {
//        创建空List：List<T> emptyList()
//        创建空Map：Map<K, V> emptyMap()
//        创建空Set：Set<T> emptySet()
        // Java11： List<String> list1 = List.of();
        List<String> list1 = Collections.emptyList();

//        创建一个元素的List：List<T> singletonList(T o)
//        创建一个元素的Map：Map<K, V> singletonMap(K key, V value)
//        创建一个元素的Set：Set<T> singleton(T o)
        // Java11： List<String> list2 = List.of("apple");
        List<String> list2 = Collections.singletonList("apple");

        // 排序
        Collections.sort(list1);
        // 洗牌
        Collections.shuffle(list2);

//        封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
//        封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
//        封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)
        test1();

//        变为线程安全的List：List<T> synchronizedList(List<T> list)
//        变为线程安全的Set：Set<T> synchronizedSet(Set<T> s)
//        变为线程安全的Map：Map<K,V> synchronizedMap(Map<K,V> m)
    }

    static void test1(){
        // 如果我们希望把一个可变List封装成不可变List，
        // 那么，返回不可变List后，最好立刻扔掉可变List的引用，
        // 这样可以保证后续操作不会意外改变原始对象，从而造成“不可变”List变化了
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // 立刻扔掉mutable的引用:
        mutable = null;
        System.out.println(immutable);
    }
}
