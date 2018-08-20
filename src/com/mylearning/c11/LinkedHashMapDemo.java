package com.mylearning.c11;

import java.util.*;

import com.mylearning.util.*;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		LinkedHashMap linkedMap = new LinkedHashMap();
		Collections2.fill(linkedMap, SimplePairGenerator.gen, 10);
		System.out.println(linkedMap);

		// Least-recently used order:
		linkedMap = new LinkedHashMap(16, 0.75f, true);
		Collections2.fill(linkedMap, SimplePairGenerator.gen, 10);
		System.out.println(linkedMap);
		for(int i = 0; i < 7; i++) // Cause accesses:
			linkedMap.get(SimplePairGenerator.gen.items[i].key);
		System.out.println(linkedMap);
		linkedMap.get(SimplePairGenerator.gen.items[0].key);
		System.out.println(linkedMap);
	}

}
