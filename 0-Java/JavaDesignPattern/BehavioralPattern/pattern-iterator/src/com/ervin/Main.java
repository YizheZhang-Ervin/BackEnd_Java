package com.ervin;


public class Main {

	public static void main(String[] args) {
		var rarray = new ReverseArrayCollection<String>("apple", "pear", "orange", "banana");
		for (String fruit : rarray) {
			System.out.println(fruit);
		}
	}
}
