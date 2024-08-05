//Abstract class with 0% abstraction, that means concrete methods and no abstract method
public class ExampleAbstractWith0PerAbstraction {
	public static void main(String[] args) {
		// Animal myDog = new Animal();//Cannot instantiate the type Animal
		Animal myDog = new Dog(); // Create a Dog object
		myDog.animalSound();
		myDog.sleep();
	}
}

//Abstract class with 0% abstraction, that means concrete methods and no abstract method
//To stop creating object of class directly
abstract class Animal {
	public void animalSound() {
		System.out.println("From Animal class The dog says: I am here");
	}

	public void sleep() {
		System.out.println("From Animal class sleep sound: Zzz");
	}
}

//Subclass (inherit from Animal)
class Dog extends Animal {
	// Override method
	public void animalSound() {
		System.out.println("From Dog class The dog says: I am here");
	}
}