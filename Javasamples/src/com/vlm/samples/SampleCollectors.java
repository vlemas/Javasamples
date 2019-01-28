package com.vlm.samples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SampleCollectors {

	public static void main(String[] args) {
		//From https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
				//trying to understand Collectors
				List<Person> people = new ArrayList<Person>();
				List<Person> sweetmanKids = new ArrayList<Person>();
				List<Person> leMasurierKids = new ArrayList<Person>();
				
				Person jessica = new Person("Jessica", "Sweetman");
				sweetmanKids.add(jessica);
				Person vickie = new Person("Vickie", "le Masurier", sweetmanKids);
				Person paul = new Person("Paul", "Sweetman", sweetmanKids);
				Person helen = new Person("Helen", "West");
				Person paull = new Person("Paul", "Le Masurier");
				leMasurierKids.add(helen);
				leMasurierKids.add(paull);
				leMasurierKids.add(vickie);
				
				Person brian = new Person("Brian", "Le Masurier", leMasurierKids);
				Person jocelyn = new Person("Jocelyn", "Le Masurier", leMasurierKids);
				people.add(vickie);
				//people.add(jessica);
				people.add(paul);
				people.add(brian);
				people.add(jocelyn);
				List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());
				System.out.println(list);

				String lists = people.stream().map(Person::getName).collect(Collectors.joining(", ", "@", "*"));
				System.out.println(lists);
				IntSummaryStatistics peopleStats = people.stream().filter(distinctByKey(Person::getDependents)).collect(Collectors.summarizingInt(person -> person.getDependents().size()));
				System.out.println("Greatest number of chidren: " + peopleStats.getMax());
				System.out.println("Total number of chidren: " + peopleStats.getSum());
				System.out.println("Lowest number of chidren: " + peopleStats.getMin());
				
	}
	
	//Thanks https://stackoverflow.com/questions/23699371/java-8-distinct-by-property
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}

}
