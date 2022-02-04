package com.ervin.goodfactory;

import com.ervin.service.AbstractFactory;
import com.ervin.service.HtmlDocument;
import com.ervin.service.WordDocument;

public class GoodFactory implements AbstractFactory {

	@Override
	public HtmlDocument createHtml(String md) {
		return new GoodHtmlDocument(md);
	}

	@Override
	public WordDocument createWord(String md) {
		return new GoodWordDocument(md);
	}
}
