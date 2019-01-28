package com.vlm.oracletutorial;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*How do you invoke the following method to find the first integer in a list that is relatively prime to a list of specified integers?
	public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
  Note that two integers a and b are relatively prime if gcd(a, b) = 1, where gcd is short for greatest common divisor.
*/

public class GenericsQuestion12 {

	    public static void main(String[] args) throws Exception {

	    	//The specified Integers
	        Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
	        UnaryPredicate<Integer> p = new RelativelyPrimePredicate(c);
	        
	        List<Integer> li = Arrays.asList(3, 4, 5, 6, 8, 11, 15, 28, 32);
	        int begin = 0;
	        int end = li.size();
	    	int firstrelativePrimePosition = findFirst(li, begin, end,  p);
	        System.out.println(li.get(firstrelativePrimePosition) +" is  the first relative prime to values "+ c);
	        
	        List<Integer> li2 = Arrays.asList(3, 4, 5, 6, 8, 15, 28, 32, 97);
	        begin = 6;
	        end = li.size();
	    	firstrelativePrimePosition = findFirst(li2, begin, end,  p);
	        System.out.println(li2.get(firstrelativePrimePosition) +" is  the first relative prime to values "+ c);
	        
	        List<Integer> li3 = Arrays.asList(3, 4, 5, 6, 8, 11, 15, 28, 32, 97);
	        begin = 0;
	        end = 6;
	        firstrelativePrimePosition = findFirst(li3, begin, end,  p);
	        System.out.println(li3.get(firstrelativePrimePosition) +" is  the first relative prime to values "+ c);
	        
	        List<Integer> li4 = Arrays.asList(3, 4, 5, 6, 8, 11, 15, 28, 32, 97);
	        begin = 6;
	        end = li.size();
	    	firstrelativePrimePosition = findFirst(li4, begin, end,  p);
	        System.out.println(li4.get(firstrelativePrimePosition) +" is  the first relative prime to values "+ c);
	        
	    }
	    
	    public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
	    	//execute the predicate test for each number in list until a match is found
	    	//returns the index of the relative prime
	    	for (; !p.test(list.get(begin)); begin++) {
	    		if (begin == end){
	    			return -1;
	    		}
	    	}
	    	return begin;
	    }
	    
	    public static <T> T findTFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
	    	T firstRelativePrime = null;
	    	//execute the predicate test for each number in list until a match is found
	    	for (T candidate : list) {
	    		if (p.test(candidate)) {
	    			//candidate is a relative prime
	    			return candidate;
	    		}
	    	}
	    	return firstRelativePrime;
	    }
}
