
//Java Program for problem solution 
//Using Stream API 
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8_Streams_nthHighestSalary {
	public static void main(String[] args) {
		// Create a HashMap to store employee names and their corresponding salaries
		Map<String, Integer> map = new HashMap<>();

		map.put("Abrar", 30000);
		map.put("Chand", 80000);
		map.put("kalam", 70000);
		map.put("Raheem", 25000);
		map.put("Kiran", 63000);
		map.put("Esa", 45000);

		// Specify the desired value of n
		int n = 2;

		// Get the nth highest salary along with the corresponding employee name
		Map.Entry<String, Integer> res = getNthHighestSalary(map, n);

		// Print the result
		System.out.println(res.getValue() + " = [ " + res.getKey() + " ]");
	}

	public static Map.Entry<String, Integer> getNthHighestSalary(Map<String, Integer> employeeSalaries, int n) {

		return employeeSalaries.entrySet().stream() // Use Stream API to sort the entries by salary in descending order
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList()).get(n - 1);// Get
																														// the
																														// nth
																														// element
																														// from
																														// the
																														// list
	}
}
