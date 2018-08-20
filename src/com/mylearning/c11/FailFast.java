package com.mylearning.c11;
import java.util.*;

public class FailFast {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Iterator it = c.iterator();
		c.add("An object");
		String s = (String)it.next();
	}
}
