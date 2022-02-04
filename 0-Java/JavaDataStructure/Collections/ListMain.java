
import java.util.*;

public class ListMain {
	public static void main(String[] args) {
//		在末尾添加一个元素：boolean add(E e)
//		在指定索引添加一个元素：boolean add(int index, E e)
//		删除指定索引的元素：E remove(int index)
//		删除某个元素：boolean remove(Object e)
//		获取指定索引的元素：E get(int index)
//		获取链表大小（包含元素的个数）：int size()
//		boolean contains(Object o)方法来判断List是否包含某个指定元素
//	    int indexOf(Object o)方法可以返回某个元素的索引，如果元素不存在，就返回-1
		test1();
		test2();
		test3();
	}

	static void test1(){
		List<String> list = new ArrayList<>();
		list.add("abc");
		list.add("xyz");
//		Java11：List<Integer> list = List.of(1, 2, 5);

		// 遍历方法1
		for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
			String s = it.next();
			System.out.println(s);
		}
		// 遍历方法2
		for (String s : list) {
			System.out.println(s);
		}
	}
	static void test2(){
		// 转为数组
		List<Integer> list2 = new LinkedList<>();
		list2.add(1);
		list2.add(2);
		Integer[] array = list2.toArray(new Integer[list2.size()]);
//		Integer[] array2 = list2.toArray(Integer[]::new);
	}
	static void test3(){
		// 数组转集合
		Integer[] array3 = { 1, 2, 3 };
		List<Integer> list3 = Arrays.asList(array3);
//		java11: List<Integer> list = List.of(array);
	}
}
