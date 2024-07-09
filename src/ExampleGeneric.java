//Java Generics was introduced to deal with type-safe objects. 
//Advantages of Java Generics
//1. Type-Safety: One can hold only a single type of objects in generics.
//2. Type Casting Is Not Required: There is no need to typecast.
//3. Compile -Time Checking: It checks all the errors of datatype related to generics at the time of compile-time so the issue will not occurat the time of runtime.
public class ExampleGeneric {
	public static void main(String[] args) {
		// Object of generic class Area with parameter Type
		// as Integer
		Area<Integer> rectangle = new Area<Integer>();
		// Object of generic class Area with parameter Type
		// as Double
		Area<Double> circle = new Area<Double>();
		rectangle.add(10);
		circle.add(2.5);
		System.out.println(rectangle.get());
		System.out.println(circle.get());
	}
}

class Area<T> {

	// T is the Datatype like String,
	// Integer of which Parameter type,
	// the class Area is of
	private T t;

	public void add(T t) {
		// this.t specify the t variable inside
		// the Area Class whereas the right hand
		// side t simply specify the value as the
		// parameter of the function add()
		this.t = t;
	}

	public T get() {
		return t;
	}

	public void getArea() {
	}

}
