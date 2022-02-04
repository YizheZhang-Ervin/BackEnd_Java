package com.ervin;

import com.ervin.organization.AdminOfIndustry;
import com.ervin.organization.Bank;
import com.ervin.organization.Company;
import com.ervin.organization.Taxation;

public class Facade {

	private AdminOfIndustry admin = new AdminOfIndustry();
	private Bank bank = new Bank();
	private Taxation taxation = new Taxation();

	public Company openCompany(String name) {
		Company c = this.admin.register(name);
		String bankAccount = this.bank.openAccount(c.getId());
		c.setBankAccount(bankAccount);
		String taxCode = this.taxation.applyTaxCode(c.getId());
		c.setTaxCode(taxCode);
		return c;
	}
}
