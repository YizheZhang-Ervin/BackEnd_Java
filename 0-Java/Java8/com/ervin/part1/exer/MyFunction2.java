package com.ervin.part1.exer;

//E - Element (在集合中使用，因为集合中存放的是元素)
//T - Type（Java 类）
//K - Key（键）
//V - Value（值）
//N - Number（数值类型）
//？ -  表示不确定的java类型
//S、U、V  - 2nd、3rd、4th types

public interface MyFunction2<T, R> {

	public R getValue(T t1, T t2);
	
}
