package com.ervin.part1.java8;

// 函数式接口
@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
