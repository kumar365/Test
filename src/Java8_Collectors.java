
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8_Collectors {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, 1000, "Chandra Shekhar", 6000),
				new Employee(1, 1000, "Rajesh", 8000), new Employee(2, 1004, "Rahul", 9000),
				new Employee(3, 1005, "Rahul", 2000), new Employee(4, 1001, "Suresh", 12000),
				new Employee(5, 1004, "Rajesh", 10000), new Employee(6, 1006, "Rahul", 5000),
				new Employee(7, 1004, "Santosh", 8500));

		// Using Collectors summingInt() method to sum all Employee salaries
		int total = employees.stream().collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("Total Employees Salary total using summingInt ::  " + total);

		// Using streams mapToInt() with sum() method
		int sum = employees.stream().mapToInt(x -> x.getSalary()).sum();
		System.out.println("Total Employees Salary total using sum :: " + sum);

		// Using Collectors summingInt() method to sum all Employee salaries
		Double average = employees.stream().collect(Collectors.averagingInt(Employee::getSalary));
		System.out.println("Total Employees Salary average = " + average);

		// average salary for each department
		Map<Integer, Double> averageSalary = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.averagingInt(Employee::getSalary)));
		System.out.println("averageSalary = " + averageSalary.values());

		// get employee data by department and total salary
		Map<Integer, Integer> employeesNew = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.summingInt(Employee::getSalary)));
		System.out.println("employeesNew = " + employeesNew);

		// top salary employee for each department
		Map<Object, Object> topEmployees = employees.stream()
				.collect(Collectors.groupingBy(e -> e.getDeptId(), Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(e -> e.getSalary())), Optional::get)));
		System.out.println("topEmployees = " + topEmployees.values());

		// top or max salary employee for each department
		Map<Object, Object> topEmployees1 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
		System.out.println("topEmployees1 = " + topEmployees1.values());

		// min or bottom salary employee for each department
		Map<Object, Object> minEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.collectingAndThen(
						Collectors.minBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
		System.out.println("minEmployees = " + minEmployees.values());

		// repeated employee name employee list
		List<?> list = employees.stream().map(Employee::getName)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println("list::" + list);

		// repeated employee name and count employee list
		employees.stream().map(Employee::getName)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.forEach(e -> System.out.println("Name::" + e.getKey() + " count::" + e.getValue()));

		// distinct employees
		List<?> distinctEmployees = employees.stream().filter(distinctByKey(Employee::getName))
				.collect(Collectors.toList());
		System.out.println("distinct employees::" + distinctEmployees);

		// distinct employees
		Set<String> set = new HashSet<>(employees.size());
		List<?> distinctEmployees1 = employees.stream().filter(e -> set.add(e.getName())).collect(Collectors.toList());
		System.out.println("distinct employees::" + distinctEmployees1);
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}
}