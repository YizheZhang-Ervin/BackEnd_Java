package com.ervin.node.decorator;

import com.ervin.node.NodeDecorator;
import com.ervin.node.TextNode;

public class UnderlineDecorator extends NodeDecorator {

	public UnderlineDecorator(TextNode target) {
		super(target);
	}

	@Override
	public String getText() {
		return "<u>" + target.getText() + "</u>";
	}
}
