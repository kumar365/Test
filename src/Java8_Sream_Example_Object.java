import java.util.stream.*;

import java.util.*;
import java.util.function.Function;

public class Java8_Sream_Example_Object {

	public static class Employee {
		private int empId;
		private String name;
		private int age;
		private int salary;

		public Employee(int empId, String name, int age, int salary) {
			super();
			this.empId = empId;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}
	}

	public static class Department {
		private int deptId;
		private String name;

		public Department(int deptId, String name) {
			super();
			this.deptId = deptId;
			this.name = name;
		}

		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static class Student {
		private String name;
		private int score;
		private Address address;

		public Student(String name, int score, Address address) {
			super();
			this.name = name;
			this.score = score;
			this.address = address;
		}

		public int getScore() {
			return score;
		}

		public String getName() {
			return name;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setScore(int score) {
			this.score = score;
		}
	}

	public static class Address {
		private String city;
		private int pinNo;

		public Address(String city, int pinNo) {
			super();
			this.city = city;
			this.pinNo = pinNo;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getPinNo() {
			return pinNo;
		}

		public void setPinNo(int pinNo) {
			this.pinNo = pinNo;
		}
	}

	public static class Notes {
		int tagId;
		String tagName;
		int age;

		public Notes(int tagId, String tagName, int age) {
			super();
			this.tagId = tagId;
			this.tagName = tagName;
			this.age = age;
		}

		public int getTagId() {
			return tagId;
		}

		public void setTagId(int tagId) {
			this.tagId = tagId;
		}

		public String getTagName() {
			return tagName;
		}

		public void setTagName(String tagName) {
			this.tagName = tagName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	}

	public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
		List<String> list = students.filter(s -> s.getScore() > passingScore).map(n -> n.name)
				.sorted(Collections.reverseOrder()).collect(Collectors.toList());
		return list;
	}

	public static List<String> studentsFromCity(Stream<Student> students, String city) {
		List<String> list = students.filter(s -> s.getAddress().getCity().equalsIgnoreCase(city)).map(n -> n.name)
				.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return list;
	}

	public static List<String> studentsFromCity(Stream<Student> students, int passingScore, String city) {
		List<String> list = students
				.filter(s -> s.getAddress().getCity().equalsIgnoreCase(city) && s.getScore() > passingScore)
				.map(n -> n.name).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return list;
	}

	// convert a List of objects into a Map by considering duplicated keys and store
	// them in sorted order
	public static void mapWithDuplicatedKeys(List<Notes> noteList) {
		System.out.println("map With Duplicated Keys:");
		Map<String, Integer> notesRecords = noteList.stream()
				.sorted(Comparator.comparingLong(Notes::getTagId).reversed())
				// sorting is based on TagId 55,44,33,22,11
				.collect(Collectors.toMap(Notes::getTagName, Notes::getTagId, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		// consider old value 44 for dupilcate key it keeps order
		System.out.println("Notes : " + notesRecords);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		List<Student> students = new ArrayList<Student>();

		students.add(new Student("Mike", 80, new Address("pune", 45)));
		students.add(new Student("James", 57, new Address("hyderabad", 50)));
		students.add(new Student("Alan", 21, new Address("mumbay", 60)));
		students.add(new Student("kok", 60, new Address("pune", 45)));
		students.add(new Student("Adam", 76, new Address("hyderabad", 50)));
		students.add(new Student("Rite", 56, new Address("mumbay", 60)));

		studentsThatPass(students.stream(), 50).forEach(System.out::println);

		System.out.println("Student names with pune");
		studentsFromCity(students.stream(), "pune").forEach(System.out::println);

		System.out.println("Student names with mumbay and pass score >35");
		studentsFromCity(students.stream(), 35, "mumbay").forEach(System.out::println);

		List<Notes> notesList = new ArrayList<>();
		notesList.add(new Notes(1, "note1", 11));
		notesList.add(new Notes(2, "note2", 22));
		notesList.add(new Notes(3, "note3", 33));
		notesList.add(new Notes(4, "note4", 44));
		notesList.add(new Notes(5, "note5", 55));
		notesList.add(new Notes(6, "note4", 66));

		mapWithDuplicatedKeys(notesList);

		// String s = "Hellow world Preadeep kumar";
		System.out.println("Enter any string::");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		Map<Character, Long> map = string.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);

		// Stream.concat(students.stream(),
		// noteList.stream).collect(Collectors.toMap((Student::getName,Notes::getTagName));
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1,"kumar1",35,5000));
		employees.add(new Employee(2,"kumar2",36,6000));
		employees.add(new Employee(3,"kumar3",37,7000));
		employees.add(new Employee(4,"kumar4",38,8000));
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department(1,"sales"));
		departments.add(new Department(2,"functional"));
		departments.add(new Department(3,"admin"));
		departments.add(new Department(4,"it"));
		

	}
}