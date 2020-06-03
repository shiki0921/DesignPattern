package com.shiki.observer;

/**
 * 观察者对象
 * @author shiki
 *
 */
public abstract class Observer {
	protected Subject subject;
	
	public abstract void update();
}
