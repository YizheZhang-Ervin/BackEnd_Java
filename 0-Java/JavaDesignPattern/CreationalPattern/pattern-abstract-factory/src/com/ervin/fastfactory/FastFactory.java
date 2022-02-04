package com.ervin.fastfactory;

import com.ervin.service.AbstractFactory;
import com.ervin.service.HtmlDocument;
import com.ervin.service.WordDocument;

public class FastFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new FastHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new FastWordDocument(md);
	}
}
