package com.mylearning;

abstract public class Event {
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	public void start() {
		eventTime = System.currentTimeMillis() + delayTime;
	}

	public boolean ready() {
		return System.currentTimeMillis() >= eventTime;
	}
	
	abstract public void action();
}
