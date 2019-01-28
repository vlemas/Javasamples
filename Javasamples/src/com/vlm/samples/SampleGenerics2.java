package com.vlm.samples;



public class SampleGenerics2 {

	//Java Generic Method
	public static <T> boolean isEqual(SampleGenerics<T> g1, SampleGenerics<T> g2){
		return g1.get().equals(g2.get());
	}
	
	public static void main(String args[]){
		SampleGenerics<String> g1 = new SampleGenerics<>();
		g1.set("Pankaj");
		
		SampleGenerics<String> g2 = new SampleGenerics<>();
		g2.set("Pankaj");
		
		boolean isEqual = SampleGenerics2.<String>isEqual(g1, g2);
		//above statement can be written simply as
		isEqual = SampleGenerics2.isEqual(g1, g2);
		//This feature, known as type inference, allows you to invoke a generic method as an ordinary method, without specifying a type between angle brackets.
		//Compiler will infer the type that is needed
	}
}
