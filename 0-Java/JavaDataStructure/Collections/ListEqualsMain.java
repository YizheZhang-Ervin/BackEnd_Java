import java.util.*;

public class ListEqualsMain {
	public static void main(String[] args) {
		List<PersonA> list = new ArrayList<>();
		list.add(new PersonA("Xiao Ming",19));
		list.add(new PersonA("Xiao Hong",20));
		list.add(new PersonA("Bob",21));
		System.out.println(list.contains(new PersonA("Bob",21))); // false
	}
}

class PersonA {
	String name;
	public int age;
	public PersonA(String name,int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PersonA) {
			PersonA p = (PersonA) o;
			return Objects.equals(this.name, p.name) && this.age == p.age;
		}
		return false;
	}
}
