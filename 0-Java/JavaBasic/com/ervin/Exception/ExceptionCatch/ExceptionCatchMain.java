package com.ervin.Exception.ExceptionCatch;

public class ExceptionCatchMain {

	public static void main(String[] args) {
		String a = "12";
		String b = "x9";
		// TODO: 捕获异常并处理
		int c = stringToInt(a);
		int d = stringToInt(b);
		System.out.println(c * d);
	}

	static int stringToInt(String s) {
		return Integer.parseInt(s);
	}
}
