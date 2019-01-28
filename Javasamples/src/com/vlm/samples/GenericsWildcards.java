
package com.vlm.samples;

import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		ints.add(3); ints.add(5); ints.add(10);

		ints.add(Integer.valueOf(4));
		double sum = sum(ints);
		System.out.println("Sum of ints="+sum);
	}

	public static double sum(List<? extends Number> list){
		double sum = 0;
		//list.add(Integer.valueOf(4), 5);
		//list.add(5, null);
		for(Number n : list){
			sum += n.doubleValue();
		}
		return sum;
	}
}
