package com.ervin.node.decorator;

import com.ervin.node.NodeDecorator;
import com.ervin.node.TextNode;

public class BoldDecorator extends NodeDecorator {

	public BoldDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<b>" + target.getText() + "</b>";
	}
}
