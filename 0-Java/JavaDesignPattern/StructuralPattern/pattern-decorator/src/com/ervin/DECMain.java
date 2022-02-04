package com.ervin;

import java.io.IOException;

import com.ervin.node.SpanNode;
import com.ervin.node.TextNode;
import com.ervin.node.decorator.BoldDecorator;
import com.ervin.node.decorator.ItalicDecorator;
import com.ervin.node.decorator.UnderlineDecorator;


public class Main {

	public static void main(String[] args) throws IOException {
		TextNode n1 = new SpanNode();
		TextNode n2 = new BoldDecorator(new UnderlineDecorator(new SpanNode()));
		TextNode n3 = new ItalicDecorator(new BoldDecorator(new SpanNode()));
		n1.setText("Hello");
		n2.setText("Decorated");
		n3.setText("World");
		System.out.println(n1.getText());
		System.out.println(n2.getText());
		System.out.println(n3.getText());
	}
}
