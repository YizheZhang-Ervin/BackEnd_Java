public class StringBuilderMain {
	public static void main(String[] args) {
		// 基本操作
		StringBuilder sb = new StringBuilder(1024);
		sb.append("Mr ")
				.append("Bob")
				.append("!")
				.insert(0, "Hello, ");
		System.out.println(sb.toString());

		// 自定义操作
		Adder adder = new Adder();
		adder.add(3)
				.add(5)
				.inc()
				.add(10);
		System.out.println(adder.value());
	}
}

class Adder {
	private int sum = 0;

	public Adder add(int n) {
		sum += n;
		return this;
	}

	public Adder inc() {
		sum ++;
		return this;
	}

	public int value() {
		return sum;
	}
}