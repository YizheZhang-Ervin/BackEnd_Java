

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

public class MapMain {
	public static void main(String[] args) {
		// get
		// put
		// containsKey
		// keySet()
		// entrySet() / getKey() / getValue()
		// HashMap初始化时默认的数组大小只有16，hashCode()获取哈希值
//		int index = key.hashCode() & 0xf; // 0xf = 15
		test1();
		test2();
		test3();
	}

	static void test1(){
		Map<String,Integer> map = new HashMap<>();
		map.put("A",111);
		map.put("B",222);

		// 遍历
		for (String key : map.keySet()) {
			Integer value = map.get(key);
			System.out.println(key + " = " + value);
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

	// EnumMap
	static void test2(){
		Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
		map.put(DayOfWeek.MONDAY, "星期一");
		map.put(DayOfWeek.TUESDAY, "星期二");
		map.put(DayOfWeek.WEDNESDAY, "星期三");
		map.put(DayOfWeek.THURSDAY, "星期四");
		map.put(DayOfWeek.FRIDAY, "星期五");
		map.put(DayOfWeek.SATURDAY, "星期六");
		map.put(DayOfWeek.SUNDAY, "星期日");
		System.out.println(map);
		System.out.println(map.get(DayOfWeek.MONDAY));
	}

	// TreeMap
	static void test3(){
		Map<PersonB, Integer> map = new TreeMap<>(new Comparator<PersonB>() {
			public int compare(PersonB p1, PersonB p2) {
//				if (p1.score == p2.score) {
//					return 0;
//				}
//				return p1.score > p2.score ? -1 : 1;
				return Integer.compare(p1.score, p2.score);
//				return p1.name.compareTo(p2.name);
			}
		});
		map.put(new PersonB("Tom", 77), 1);
		map.put(new PersonB("Bob", 66), 2);
		map.put(new PersonB("Lily", 99), 3);
		for (PersonB key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println(map.get(new PersonB("Bob", 66))); // null?
	}
}

class PersonB {
	String name;
	public int score;
	public PersonB(String name, int score){
		this.name = name;
		this.score = score;
	}
	public String toString() {
		return String.format("{%s: score=%d}", name, score);
	}

	public int hashCode() {
//		int h = 0;
//		h = 31 * h + firstName.hashCode();
//		h = 31 * h + lastName.hashCode();
//		h = 31 * h + age;
//		return h;
		return Objects.hash(name);
	}
}

enum DayOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}