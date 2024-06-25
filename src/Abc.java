import java.util.concurrent.ThreadLocalRandom;

public class Abc {
	public static void main(String[] args) {
		int randomNum = ThreadLocalRandom.current().nextInt(0, 1000000);
		System.out.println(randomNum);
	}
}
