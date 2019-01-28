package com.vlm.samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SampleFunction {
	public static void main(String args[]) {
		Function<Employee, String> funcEmpToString = (Employee e) -> {
			return e.getName();
		};
		Function<String, String> funcNameToInitial = (String name) -> {
			return name.substring(0, 1);
		};
		Function<Employee, Employee> funcEmployeeSurnameOnly = (Employee e) -> {
			e.setName(e.getName().substring(e.getName().lastIndexOf(' ') + 1, (e.getName().length())));
			return e;
		};
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));
		List<Employee> empIdentityList = applyIdentityToEmpList(employeeList, Function.identity());
		List<String> empNameList = convertEmpListToNamesList(employeeList, funcEmpToString);
		List<String> empInitialList = convertEmpListToNamesList(employeeList,
				funcEmpToString.andThen(funcNameToInitial));
		List<String> empSurnameList = convertEmpListToNamesList(employeeList,
				funcEmpToString.compose(funcEmployeeSurnameOnly));
		
		empNameList.forEach(System.out::println);
		empInitialList.forEach(System.out::println);
		empSurnameList.forEach(System.out::println);
		empIdentityList.forEach(System.out::println);
		// }
	}

	public static List<Employee> applyIdentityToEmpList(List<Employee> employeeList,
			Function<Employee, Employee> funcEmpToEmp) {
		List<Employee> empNameList = new ArrayList<Employee>();
		for (Employee emp : employeeList) {
			empNameList.add(funcEmpToEmp.apply(emp));
		}
		return empNameList;
	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
			Function<Employee, String> funcEmpToString) {
		List<String> empNameList = new ArrayList<String>();
		for (Employee emp : employeeList) {
			empNameList.add(funcEmpToString.apply(emp));
		}
		return empNameList;
	}

}