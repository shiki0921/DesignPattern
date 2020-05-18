package com.shiki.decorator;

public class BoldDecorator extends NodeDecorator {

	protected BoldDecorator(TextNode target) {
		super(target);
	}

	public String getText() {
		return "<b>" + target.getText() + "</b>";
	}
	
}
