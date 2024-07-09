import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class ExampleTransient {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("D:/AidXpert_Workspace/Test/src/login_details.txt"));
		input.useDelimiter(";");
		Test test = null;
		while (input.hasNext()) {

			test = new Test(input.next(), input.nextInt(), input.next(), input.next());

		}

		/*
		 * Transient variable will be shown null due to security reasons.
		 */
		System.out.println("Accesskey: " + test.accessKey);
		System.out.println("Age: " + test.age);
		System.out.println("Name: " + test.name);
		System.out.println("Address: " + test.address);
	}
}

class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Making Accesskey transient for security
	transient String accessKey;

	// Making age transient as age can be calculated from Date of Birth and current
	// date.
	transient int age;

	// serialize other fields
	String name, address;

	public Test(String accessKey, int age, String name, String address) {
		this.accessKey = accessKey;
		this.age = age;
		this.name = name;
		this.address = address;
	}
}
