package com.mylearning.c11;

import java.util.Arrays;

import com.mylearning.util.AlphabeticComparator;
import com.mylearning.util.Arrays2;

public class AlphabeticSorting {

	public static void main(String[] args) {
		String[] sa = new String[30];
		Arrays2.fill(sa, new Arrays2.RandStringGenerator(5));
		System.out.println("before sorting: " + Arrays.asList(sa));
		Arrays.sort(sa, new AlphabeticComparator());
		System.out.println("after sorting: " + Arrays.asList(sa));
	}

}
