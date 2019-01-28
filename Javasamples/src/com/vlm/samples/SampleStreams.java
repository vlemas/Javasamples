package com.vlm.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SampleStreams {

	public static void main(String[] args) {
		//forEach()
		System.out.println("Random numbers:");
		Random random = new Random();
		random.ints().limit(5).forEach(System.out::println);
		System.out.println("Random numbers, Sorted:");
		random.ints().limit(5).sorted().forEach(System.out::println);
		//map()
		System.out.println("Mapped unique square numbers:");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//get list of unique squares
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		squaresList.forEach(System.out::println);
		//
		System.out.println("List of elements:");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		strings.forEach(System.out::println);
		System.out.println("filter out empty elements:");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("Non empty elements: "+filtered.stream().count());
		filtered.forEach(System.out::println);

		//get count of empty strings

		System.out.println("Number of empty strings:");
		long count = strings.stream().filter(string -> string.isEmpty()).count();
		System.out.println(count);
		
		//Collectors
		//List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);

		
		//Summary statistics
		List<Integer> numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers1.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		
	}

}
