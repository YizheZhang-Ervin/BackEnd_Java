package com.ervin;

import java.io.IOException;

import com.ervin.organization.Company;


public class Main {

	public static void main(String[] args) throws IOException {
		Facade facade = new Facade();
		Company c = facade.openCompany("Facade Software Ltd.");
		System.out.println(c);
	}
}
