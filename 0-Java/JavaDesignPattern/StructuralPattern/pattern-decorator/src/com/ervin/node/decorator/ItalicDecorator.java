package com.ervin.node.decorator;

import com.ervin.node.NodeDecorator;
import com.ervin.node.TextNode;

public class ItalicDecorator extends NodeDecorator {

	public ItalicDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<i>" + target.getText() + "</i>";
	}
}
