//Create a thread class implementing Run able interface
class ExampleThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("user Thread:" + i);
		}
	}

	public static void main(String[] args) {

		ExampleThread2 td = new ExampleThread2();// creating the object

		Thread t = new Thread(td);// attaching the user thread

		t.start();// executing the user thread
	}
}
