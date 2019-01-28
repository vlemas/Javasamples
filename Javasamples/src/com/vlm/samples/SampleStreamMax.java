package com.vlm.samples;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class SampleStreamMax {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(1, "Peter Gibbons"),
				new Employee(2, "Samir Nagheenanajar"), new Employee(3, "Michael Bolton"),
				new Employee(4, "Milton Waddams"));

		// Anonymous inner class implementation of Comparator<Employee>
		//
		Employee maxId = employees.stream().max(new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getId() - e2.getId();
			}
		}).orElse(Employee.DEFAULT_EMPLOYEE);

		// Anonymous inner class implementation of Comparator<Object>
		Employee maxName = employees.stream().max(new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				return o1.toString().compareTo(o2.toString());
			}
		}).orElse(Employee.DEFAULT_EMPLOYEE);

		System.out.println(maxId); // Milton Waddams
		System.out.println(maxName); // Samir Naga...
		// Better way to do it
		// Because it is more compact. Employee::getId is a Function
		//comparing: static <T,U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T,? extends U> keyExtractor)


		Employee maxId2 = employees.stream().max(comparingInt(Employee::getId)).orElse(Employee.DEFAULT_EMPLOYEE);
		Employee maxName2 = employees.stream().max(comparing(Object::toString)).orElse(Employee.DEFAULT_EMPLOYEE);

		System.out.println(maxId2); // same results
		System.out.println(maxName2); // as before
		//Creating a list of employee names
		//Map returns a new Stream, so collect() is used to turn it into a list
		List<String> names = employees.stream().map(Employee::getName).collect(toList());
		System.out.println(names); // as before
		
		
		//Example 16. Sorting Map elements by key and printing
		// Break this one down to understand it a bit better
		// Add employees to a map using id as key
		Map<Integer, Employee> employeeMap = employees.stream().collect(toMap(Employee::getId, Function.identity()));

		// Sort employees by id and print them
		System.out.println("Sorted by key:");
		employeeMap.entrySet().stream()
		    .sorted(Map.Entry.comparingByKey())
		    .forEach(entry -> {
		        System.out.println(entry.getKey() + ": " + entry.getValue());
		    });
		
		//Broken down into steps
		//mapping a Employee onto the employee id
		// Wont work! Function<Integer> functionId = (Employee::getId);
		// TODO Remove Spurious cast to get it working... (Collector<Employee, Integer, Map<Integer, Object>>)
		//toMap method: static <T,K,U> Collector<T,?,Map<K,U>>	toMap(Function<? super T,? extends K> keyMapper, Function<? super T,? extends U> valueMapper)
		//T = Employee, K = Integer???, U = Employee
		//T and U are employee so use Function.identity()
		List<EmployeeInteger> employeeIntegers = Arrays.asList(new EmployeeInteger(1, "Peter Gibbons"),
				new EmployeeInteger(2, "Samir Nagheenanajar"), new EmployeeInteger(3, "Michael Bolton"),
				new EmployeeInteger(4, "Milton Waddams"));

	
		Collector<EmployeeInteger, Integer, Map<Integer, EmployeeInteger>> employeeCollector =  toMap(EmployeeInteger::getId, Function.identity());
		Stream<EmployeeInteger> employeesStream = employeeIntegers.stream();
		Map<Integer, Object> employeeStepMap = (Map<Integer, Object>) employeesStream.collect(employeeCollector);

	}

}
