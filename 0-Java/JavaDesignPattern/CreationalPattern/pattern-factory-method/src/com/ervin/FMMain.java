package com.ervin;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;


public class FMMain {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		LocalDate ld = LocalDateFactory.fromInt(20200202);
		System.out.println(ld);
		LocalDate ld2 = LocalDateFactory.fromInt(20200202);
		System.out.println(ld == ld2);
	}
}
