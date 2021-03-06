package com.mylearning.c11;

import java.util.*;
import java.lang.reflect.*;
public class SpringDetector {
	// Uses a Groundhog or class derived from Groundhog:
	public static void detectSpring(Class groundHogClass) throws Exception {
		Constructor ghog = groundHogClass.getConstructor(new Class[] {int.class});
		Map map = new HashMap();
		for(int i = 0; i < 10; i++)
			map.put(ghog.newInstance(new Object[]{ new Integer(i) }), new Prediction());
		System.out.println("map = " + map + "\n");
		Groundhog gh = (Groundhog)ghog.newInstance(new Object[]{ new Integer(3) });
		System.out.println("Looking up prediction for " + gh);
		if(map.containsKey(gh))
			System.out.println((Prediction)map.get(gh));
		else
			System.out.println("Key not found: " + gh);
	}
	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
	}
}
