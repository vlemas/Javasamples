package com.vlm.oracletutorial;

import java.util.ArrayList;
import java.util.List;

public class RunGenericsTutorial {

	public static void main(String[] args) {
		//Create a list containing the of food you wish to buy in a supermarket.
		//The list should have the following: milk, cheese, chicken, carrot, and rice. 
		//Use .add() to add the elements to the list.
		List<String> food = new ArrayList<>();
		food.add("milk"); food.add("cheese"); food.add("chicken"); food.add("carrot");  food.add("rice");

		//old hat!:
		//for (String item: food) {
		//	System.out.println(item);
		//}
		
		food.stream().forEach(System.out::println);
	}

}
