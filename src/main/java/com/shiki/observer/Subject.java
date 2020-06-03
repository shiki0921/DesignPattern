package com.shiki.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察对象
 * @author shiki
 *
 */
public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	private int state;
	
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	public int getState(){
		return this.state;
	}
	
	public void setState(int state){
		this.state = state;
		notifyAllObservers();
	}
	
	public void notifyAllObservers(){
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
