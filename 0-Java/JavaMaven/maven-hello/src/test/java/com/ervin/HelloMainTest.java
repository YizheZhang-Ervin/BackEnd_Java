package com.ervin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HelloMainTest {

	@Test
	void test() {
		int abs = Math.abs(-123);
		assertEquals(123, abs);
	}

}
