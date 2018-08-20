package com.mylearning.c11;

import java.util.Arrays;
import java.util.Random;

import com.mylearning.util.Arrays2;
import com.mylearning.util.Generator;

public class CompType implements Comparable {
	int i;
	int j;
	public CompType(int n1, int n2) {
		i = n1;
		j = n2;
	}
	public String toString() {
		return "[i = " + i + ", j = " + j + "]";
	}
	public int compareTo(Object rv) {
		int rvi = ((CompType)rv).i;
		return (i < rvi ? -1 : (i == rvi ? 0 : 1));
	}
	private static Random r = new Random();
	private static int randInt() { return r.nextInt(100); }
	public static Generator generator() {
		return new Generator() {
			public Object next() {
				return new CompType(randInt(), randInt());
			}
		};
	}
	public static void main(String[] args) {
		CompType[] a = new CompType[10];
		Arrays2.fill(a, generator());
		System.out.println("before sorting, a = " + Arrays.asList(a));
		Arrays.sort(a);
		System.out.println("after sorting, a= " + Arrays.asList(a));
	}
}
