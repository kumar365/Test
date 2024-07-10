import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//To make An immutable class Following are the requirements: 
//1) The class must be declared as final so that child classes can’t be created.
//2) Data members in the class must be declared private so that direct access is not allowed.
//3) Data members in the class must be declared as final so that we can’t change the value of it after object creation.
//4) A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
//5) Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

public class ExampleImmutable {
	public static void main(String[] args) {

		List<String> address = new ArrayList<String>();
		address.add("Hyd East");
		address.add("Hyd West");
		// Creating Map object with reference to HashMap
		Map<String, String> map = new HashMap<>();

		// Adding elements to Map object using put() method
		map.put("1", "first");
		map.put("2", "second");

		// creating object of immutable class Student
		Student s = new Student("ABC", 101, address, map);

		// Calling the above methods 1,2,3 of class1 inside main() method in class2 and
		// executing the print statement over them
		System.out.println(s.getName());
		System.out.println(s.getRegNo());
		System.out.println("Before altering list:: " + s.getAddress());
		System.out.println("Before altering map:: " + s.getMetadata());

		// Uncommenting below line causes error
		// s.regNo = 102;

		address.add("Hyd North");
		System.out.println("After altering list:: " + s.getAddress());
		s.getAddress().add("Hyd South");
		System.out.println("After altering list:: " + s.getAddress());

		map.put("3", "third");

		// Remains unchanged due to deep copy in constructor
		System.out.println("After altering map:: " + s.getMetadata());

		s.getMetadata().put("4", "fourth");
		// Remains unchanged due to deep copy in getter
		System.out.println("After altering map:: " + s.getMetadata());
	}
}
