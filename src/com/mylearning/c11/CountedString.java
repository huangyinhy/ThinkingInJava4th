package com.mylearning.c11;
import java.util.*;

public class CountedString {
	private String s;
	private int id = 0;
	private static List created = new ArrayList();
	
	public CountedString(String str) {
		s = str;
		created.add(s);
		Iterator it = created.iterator();
		
		// Id is the total number of instances
		// of this string in use by CountedString:
		while(it.hasNext())
			if(it.next().equals(s))
				id++;
	}
	
	public String toString() {
		return "String: " + s + " id: " + id +
				" hashCode(): " + hashCode();
	}
	
	public int hashCode() {
		// Very simple approach:
		// return s.hashCode() * id;
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37*result + s.hashCode();
		result = 37*result + id;
		return result;
	}
	
	public boolean equals(Object o) {
		return (o instanceof CountedString)
				&& s.equals(((CountedString)o).s)
				&& id == ((CountedString)o).id;
	}
	
	public static void main(String[] args) {
		Map map = new HashMap();
		CountedString[] cs = new CountedString[10];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], new Integer(i));
		}
		System.out.println(map);
		for(int i = 0; i < cs.length; i++) {
			System.out.println("Looking up " + cs[i]);
			System.out.println(map.get(cs[i]));
		}
	}
}