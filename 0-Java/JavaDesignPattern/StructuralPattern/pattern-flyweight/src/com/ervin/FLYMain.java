package com.ervin;


public class Main {

	public static void main(String[] args) {
		Student s1 = Student.create(1, "小明");
		Student s2 = Student.create(2, "小红");
		Student s3 = Student.create(1, "小明");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s1 == s3); // true
	}
}
