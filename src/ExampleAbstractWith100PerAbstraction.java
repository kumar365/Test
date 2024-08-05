//Abstract class with 100% abstraction no concrete method and 2 abstract methods
public class ExampleAbstractWith100PerAbstraction {
	public static void main(String[] args) {
		// Color myColor = new Color();//Cannot instantiate the type Color
		Color myColor = new Red(); // Create a Red object
		myColor.colorName();
		myColor.colorCode();
	}
}

//Abstract class with 100% abstraction no concrete method and 2 abstract methods
abstract class Color {

	public abstract void colorName();

	public abstract void colorCode();

}

//Subclass (inherit from Color)
class Red extends Color {

	@Override // Overrided method
	public void colorCode() {
		System.out.println("From Red class The Red color code: #12345");
	}

	@Override // Overrided method
	public void colorName() {
		System.out.println("From Red class The Red color name: red");
	}
}