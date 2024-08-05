
//Java code to explain overcome cloning issue with singleton

class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

//SingletonNew class
class SingletonNew extends SuperClass {

	// public instance initialized when loading the class
	public static SingletonNew instance = new SingletonNew();

	private SingletonNew() {
		// private constructor
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException();
		return instance;
	}
}

public class ExampleSingleton8 {

	// Main driver method
	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonNew instance1 = SingletonNew.instance;
		SingletonNew instance2 = (SingletonNew) instance1.clone();

		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}
}
