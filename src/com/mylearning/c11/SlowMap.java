package com.mylearning.c11;

import java.util.*;

import com.mylearning.util.Collections2;

public class SlowMap extends AbstractMap {
	private List
		keys = new ArrayList(),
		values = new ArrayList();
	public Object put(Object key, Object value) {
		Object result = get(key);
		if(!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return result;
	}
	public Object get(Object key) {
		if(!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}
	public Set entrySet() {
		Set entries = new HashSet();
		Iterator
			ki = keys.iterator(),
			vi = values.iterator();
		while(ki.hasNext())
			entries.add(new MPair(ki.next(), vi.next()));
		return entries;
	}
	public String toString() {
		StringBuffer s = new StringBuffer("{");
		Iterator
			ki = keys.iterator(),
			vi = values.iterator();
		while(ki.hasNext()) {
			s.append(ki.next() + "=" + vi.next());
			if(ki.hasNext()) s.append(", ");
		}
		s.append("}");
		return s.toString();			
	}
	
	public static void main(String[] args) {
		SlowMap m = new SlowMap();
		Collections2.fill(m, Collections2.geography, 15);
		System.out.println(m);
	}
}
