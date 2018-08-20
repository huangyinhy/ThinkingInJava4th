package com.mylearning.c11;

import java.util.Arrays;
import java.util.Comparator;

import com.mylearning.util.Arrays2;

class CompTypeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		int j1 = ((CompType)o1).j;
		int j2 = ((CompType)o2).j;
		return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
	}
}
public class ComparatorTest {

	public static void main(String[] args) {
		CompType[] a = new CompType[10];
		Arrays2.fill(a, CompType.generator());
		System.out.println("before sorting, a = " + Arrays.asList(a));
		Arrays.sort(a, new CompTypeComparator());
		System.out.println("after sorting, a = " + Arrays.asList(a));
	}

}
