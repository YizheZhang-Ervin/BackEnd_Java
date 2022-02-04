package com.ervin;

import java.math.BigDecimal;

import com.ervin.chain.CEOHandler;
import com.ervin.chain.DirectorHandler;
import com.ervin.chain.HandlerChain;
import com.ervin.chain.ManagerHandler;
import com.ervin.chain.Request;


public class CRMain {

	public static void main(String[] args) {
		HandlerChain chain = new HandlerChain();
		chain.addHandler(new ManagerHandler());
		chain.addHandler(new DirectorHandler());
		chain.addHandler(new CEOHandler());
		chain.process(new Request("Bob", new BigDecimal("123.45")));
		chain.process(new Request("Alice", new BigDecimal("1234.56")));
		chain.process(new Request("Bill", new BigDecimal("12345.67")));
		chain.process(new Request("John", new BigDecimal("123456.78")));
	}
}
