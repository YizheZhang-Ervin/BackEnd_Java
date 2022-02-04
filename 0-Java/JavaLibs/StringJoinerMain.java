import java.util.StringJoiner;

public class StringJoinerMain{
	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	static void test3(){
		String[] names = {"Bob", "Alice", "Grace"};
		String s = String.join(", ", names);
	}

	static void test2(){
		String[] names = {"Bob", "Alice", "Grace"};
		StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
		for (String name : names) {
			sj.add(name);
		}
		System.out.println(sj.toString());
	}

	static void test1(){
		String[] names = {"Bob", "Alice", "Grace"};
		StringJoiner sj = new StringJoiner(", ");
		for (String name : names) {
			sj.add(name);
		}
		System.out.println(sj.toString());
	}
}
