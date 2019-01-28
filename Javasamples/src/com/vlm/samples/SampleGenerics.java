package com.vlm.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//@SuppressWarnings("rawtypes") 
public class SampleGenerics<T> {


	private T t;
	
	public T get(){
		return this.t;
	}
	
	public void set(T t1){
		this.t=t1;
	}
	public static void numsUpTo(Integer num, List<? super Integer> output) {
	    IntStream.rangeClosed(1, num)
	        .forEach(output::add);
	}
	
	public static void main(String args[]){
		ArrayList<Integer> integerList = new ArrayList<>();
		ArrayList<Number> numberList = new ArrayList<>();
		ArrayList<Object> objectList = new ArrayList<>();

		numsUpTo(5, integerList);
		numsUpTo(5, numberList);
		numsUpTo(5, objectList);
		
		System.out.println(integerList);
		System.out.println(numberList);
		System.out.println(objectList);
	}
}



