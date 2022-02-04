package com.ervin;

import com.ervin.node.CommentNode;
import com.ervin.node.ElementNode;
import com.ervin.node.Node;
import com.ervin.node.TextNode;


public class Main {

	public static void main(String[] args) {
		Node root = new ElementNode("school");
		root.add(new ElementNode("classA").add(new TextNode("Tom")).add(new TextNode("Alice")));
		root.add(new ElementNode("classB").add(new TextNode("Bob")).add(new TextNode("Grace"))
				.add(new CommentNode("comment...")));
		System.out.println(root.toXml());
	}
}
