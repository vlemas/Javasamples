package com.vlm.samples;

import com.vlm.oracletutorial.answers.Algorithm;

public class TestGCD {

	public static void main(String[] args) {
		System.out.println("gcd of 1 and 2 is "+Algorithm.gcd(1, 2));
		System.out.println("gcd of 2 and 6 is "+Algorithm.gcd(2, 6));
		System.out.println("gcd of 3 and 7 is "+Algorithm.gcd(3, 7));
		System.out.println("gcd of 6 and 24 is "+Algorithm.gcd(6, 24));
		System.out.println("gcd of 24 and 6 is "+Algorithm.gcd(24, 6));
		System.out.println("gcd of 24 and 9 is "+Algorithm.gcd(24, 9));
		System.out.println("gcd of 24 and 12 is "+Algorithm.gcd(24, 12));
		System.out.println("gcd of 4 and 9 is "+Algorithm.gcd(4, 9));
	}

}
