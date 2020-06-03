package com.shiki.observer;

/**
 * 实体观察者对象
 * @author shiki
 *
 */
public class BinaryObserver extends Observer{
	
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println( "Binary String: " 
			      + Integer.toBinaryString( subject.getState() ) ); 
	}

}
