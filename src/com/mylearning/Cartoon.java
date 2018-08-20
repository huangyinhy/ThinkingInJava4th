package com.mylearning;

class Art {
	Art (int i) {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	public Drawing(int i) {
		super(i);
		System.out.println("Drawing constructor");
	}
}

public class Cartoon extends Drawing {
	private Cartoon () {
		super(11);
		System.out.println("Cartoon constructor");
	}
	public static void main(String[] args) {
//		Cartoon x = new Cartoon();
		Cartoon x = (Cartoon) new Drawing(0);
	}

}
