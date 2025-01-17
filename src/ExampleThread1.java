
class ExampleThread1 extends Thread {
	// functionality of user Thread
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("user Thread:" + i);
		}
	}

	public static void main(String[] args) {

		ExampleThread1 td = new ExampleThread1();// creating the object

		Thread t = new Thread(td);// attaching the user thread

		t.start();// executing the user thread
	}
}
