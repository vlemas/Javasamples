package com.vlm.oracletutorial;

import java.math.BigInteger;
import java.util.Collection;

public class RelativelyPrimePredicate implements UnaryPredicate<Integer> {
	private Collection<Integer> listOfIntegers;
	public RelativelyPrimePredicate(Collection<Integer> list) {
		listOfIntegers = list;
		
	}
public boolean test(Integer candidate) {
	//test for relative prime: Two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.
	//return true if candidate is relatively prime to all numbers in listOfIntegers
	boolean result = false;
		for(Integer number : listOfIntegers) {
			System.out.println("gcd of "+ candidate +" and "+ number +" is "+gcd(candidate, number));
			if (gcd(candidate, number) == 1) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
	return result;
}

private int gcd(Integer a, Integer b) {
	//convert to BigInteger and use gcd method
	BigInteger bigA = BigInteger.valueOf(a.intValue());
	BigInteger bigB = BigInteger.valueOf(b.intValue());

	return bigA.gcd(bigB).intValue();
	
}
}
