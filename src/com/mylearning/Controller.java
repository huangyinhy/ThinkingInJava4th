package com.mylearning;

import java.util.*;

public class Controller {
	private List eventList = new ArrayList();
	public void addEvent(Event c) { eventList.add(c); }
	public void run() {
		while(eventList.size() > 0) {
			for(int i = 0; i < eventList.size(); i++) {
				Event e = (Event)eventList.get(i);
				if(e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(i);
				}
			}
		}
	}
}
