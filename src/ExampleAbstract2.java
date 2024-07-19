//Abstract class with 50% abstraction 1 concrete method and 1 abstract method
public class ExampleAbstract2 {
	public static void main(String[] args) {
		// Vehical myVehical = new Vehical();//Cannot instantiate the type Vehical
		Vehical myVehical = new Car(); // Create a Car object
		myVehical.vehicalSound();
		myVehical.hourn();
	}
}

//Abstract class with 50% abstraction 1 concrete method and 1 abstract method
abstract class Vehical {

	public abstract void vehicalSound();

	public void hourn() {
		System.out.println("From Vehical class hourn sound: Zzz");
	}
}

//Subclass (inherit from Vehical)
class Car extends Vehical {
	// Override method
	public void vehicalSound() {
		System.out.println("From Car class The car says: I am here");
	}
}