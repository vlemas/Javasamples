package com.vlm.oracletutorial;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

//https://docs.oracle.com/javase/tutorial/java/generics/QandE/generics-questions.html
public class GenericsTutorialExercises {

	//Question One.
	//Write a generic method to count the number of elements in a collection 
	//that have a specific property (for example, odd integers, prime numbers, palindromes).

	public static <T> int countElements(Collection<T> c, IsItIsntIt<T> p) {
		int count = 0;
		for (T elem : c) {
			if (p.test(elem)){
				count++;
			}
		}
		return count;
	}
	
	public interface IsItIsntIt<T> extends Predicate<T> {

		@Override
		public boolean test(T t) ;

	}
	
	//Question 3.
	//Write a generic method to exchange the positions of two different elements in an array.

	public static <T> void exchangeElements(T[] array, int pos1, int pos2){
		T element1 = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = element1;
	}
	
	//Question 8.
	//Write a generic method to find the maximal element in the range [begin, end) of a list.
	//Not the same as the model answer but in that T also extends 

	public static <T> T findMaximal(List<T> list, Comparator<T> c, int begin, int end) {
		List<T> sublist = list.subList(begin, end);
		T maxItem = sublist.get(0);
			
		for (T item: sublist) {
			if (c.compare(maxItem, item) < 0) {
				maxItem = item;
			}
		}
		return (maxItem);
	}
	
	public static void main(String[] args) {
		questionOne();
		questionThree();
		questionEight();
	}
	
	private static void questionOne() {
		//display the number of odd numbers in the array
		List<Integer> numbers = Arrays.asList(1,24,56,26,85,95,35,27);
		
		//now count the odd integers
		int odds = countElements(numbers, new IsItIsntIt<Integer>() {
			//@override
			public boolean test(Integer number) {
				return number % 2 != 0;
			}
		});
		System.out.println("number of odds ="+odds);
	}


	private static void questionThree() {
		String[] words = {"apple", "Bear", "Car", "Dog", "Egg"};
		System.out.println(Arrays.toString(words));
		exchangeElements(words, 1, 3);
		System.out.println(Arrays.toString(words));
			
	}
	
	private static void questionEight() {
		//Create a List of names and find the last in the alphabet
		List<String> names = Arrays.asList("Fred", "Harry", "Connor", "Zane", "Rocco", "Sam");
		System.out.println("Some Names:");
		names.forEach(System.out::println);
		System.out.println();
		names.subList(1, 4).forEach(System.out::println);
		System.out.println();
		System.out.print("Last Name: ");
		System.out.println(findMaximal(names ,String::compareTo ,0, names.size()));
		System.out.print("Last Name in sublist 2-4: ");
		System.out.println(findMaximal(names ,String::compareTo ,1, 4));
	}
}
