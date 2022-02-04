package com.ervin;

import java.io.IOException;
import java.nio.file.Paths;

import com.ervin.fastfactory.FastFactory;
import com.ervin.goodfactory.GoodFactory;
import com.ervin.service.AbstractFactory;
import com.ervin.service.HtmlDocument;
import com.ervin.service.WordDocument;

public class AFMain {

	public static void main(String[] args) throws IOException {
		AbstractFactory fastFactory = new FastFactory();
		HtmlDocument fastHtml = fastFactory.createHtml("#Hello\nHello, world!");
		System.out.println(fastHtml.toHtml());
		fastHtml.save(Paths.get(".", "fast.html"));
		WordDocument fastWord = fastFactory.createWord("#Hello\nHello, world!");
		fastWord.save(Paths.get(".", "fast.doc"));

		AbstractFactory goodFactory = new GoodFactory();
		HtmlDocument goodHtml = goodFactory.createHtml("#Hello\nHello, world!");
		System.out.println(goodHtml.toHtml());
		goodHtml.save(Paths.get(".", "good.html"));
		WordDocument goodWord = goodFactory.createWord("#Hello\nHello, world!");
		goodWord.save(Paths.get(".", "good.doc"));
	}
}
