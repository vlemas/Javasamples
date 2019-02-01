package com.vlm.samples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import static java.util.stream.Collectors.toMap;
import static java.util.Comparator.comparing;

// From https://nofluffjuststuff.com/magazine/2016/09/time_to_really_learn_generics_a_java_8_perspective#sort_by_key
public class SampleMap {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));

		// Add employees to a map using id as key
		Map<Integer, Employee> employeeMap = employees.stream().collect(toMap(Employee::getId, Function.identity()));

		// Sort employees by id and print them
		System.out.println("Sorted by key:");
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		});
		// now we have to use the overloaded version of comparingByValue that receives a
		// Comparator
		System.out.println("Sorted by value:");
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(comparing(Employee::getName)))
				.forEach(entry -> {
					System.out.println(entry.getKey() + ": " + entry.getValue());
				});

	}

}
