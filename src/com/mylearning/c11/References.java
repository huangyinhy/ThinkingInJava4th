package com.mylearning.c11;

import java.lang.ref.*;
import java.util.*;

class VeryBig {
	private static final int SZ = 10000;
	private double[] d = new double[SZ];
	private String ident;
	public VeryBig(String id) { ident = id; }
	public String toString() { return ident; }
	public void finalize() {
		System.out.println("Finalizing " + ident);
	}
}

public class References {
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();
	public static void checkQueue() {
		Reference<? extends VeryBig> inq = rq.poll();
		if(inq != null)
			System.out.println("In queue: " + inq.get());
	}
	public static void main(String[] args) {
		int size = 10;
		// Or, choose size via the command line:
		if(args.length > 0)
			size = Integer.parseInt(args[0]);
		LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
		for(int i = 0; i < size; i++) {
			sa.add(new SoftReference<VeryBig>(
					new VeryBig("Soft " + i), rq));
			System.out.println("Just created: " + sa.getLast());
			checkQueue();
		}
		LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
		for(int i = 0; i < size; i++) {
			wa.add(new WeakReference<VeryBig>(
					new VeryBig("Weak " + i), rq));
			System.out.println("Just created: " + wa.getLast());
			checkQueue();
		}
		SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("Soft"));
		WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("Weak"));
		System.gc();
		LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
		for(int i = 0; i < size; i++) {
			pa.add(new PhantomReference<VeryBig>(
					new VeryBig("Phantom " + i), rq));
			System.out.println("Just created: " + pa.getLast());
			checkQueue();
		}
	}
}