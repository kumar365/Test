
// Java Program to Create An Immutable Class 

// Class 1 An immutable class

//Following are the requirements: 
// 1) The class must be declared as final so that child classes can’t be created.
// 2) Data members in the class must be declared private so that direct access is not allowed.
// 3) Data members in the class must be declared as final so that we can’t change the value of it after object creation.
// 4) A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
// 5) Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class Student {

	// Member attributes of final class
	private final String name;
	private final int regNo;
	private final List<String> address;
	private final Map<String, String> metadata;

	// Constructor of immutable class Parameterized constructor
	public Student(String name, int regNo, List<String> address, Map<String, String> metadata) {

		// This keyword refers to current instance itself
		this.name = name;
		this.regNo = regNo;

		List<String> tempAddress = new ArrayList<String>();// deep copy

		for (String string : address) {
			tempAddress.add(string);// deep copy
		}

		this.address = tempAddress;

		// Creating Map object with reference to HashMap Declaring object of string type
		Map<String, String> tempMap = new HashMap<>(); // deep copy

		// Iterating using for-each loop
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue()); // deep copy
		}

		this.metadata = tempMap;
	}

	// Method 1
	public String getName() {
		return name;
	}

	// Method 2
	public int getRegNo() {
		return regNo;
	}

	// Note that there should not be any setters

	// Method 3
	public List<String> getAddress() {
		List<String> tempAddress = new ArrayList<String>();// deep copy

		for (String string : this.address) {
			tempAddress.add(string);// deep copy
		}
		return tempAddress;
	}

	// Method 4 User -defined type To get meta data
	public Map<String, String> getMetadata() {

		// Creating Map with HashMap reference
		Map<String, String> tempMap = new HashMap<>();// deep copy

		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());// deep copy
		}
		return tempMap;
	}

}