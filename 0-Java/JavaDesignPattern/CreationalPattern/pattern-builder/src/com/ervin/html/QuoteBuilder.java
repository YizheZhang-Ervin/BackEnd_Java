package com.ervin.html;

public class QuoteBuilder {

	public String buildQuote(String line) {
		return "<blockquote>" + line.substring(1).strip() + "</blockquote>";
	}
}
