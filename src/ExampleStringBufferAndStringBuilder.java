import java.util.GregorianCalendar;

public class ExampleStringBufferAndStringBuilder {
	public static void main(String[] args) {
		stringBufferTest();
		stringBuilderTest();
	}
	// String is immutable in Java. So it’s suitable to use in a multi-threaded
	// environment.
	// We can share it across functions because there is no concern of data
	// inconsistency.

	// StringBuffer and StringBuilder are mutable objects in Java. They provide
	// append(), insert(), delete(), and substring() methods for String
	// manipulation.

	// StringBuffer mutable and thread safe as it is synchronized
	public static void stringBufferTest() {
		System.gc();
		long start = new GregorianCalendar().getTimeInMillis();
		long startMemory = Runtime.getRuntime().freeMemory();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10000000; i++) {
			sb.append(":").append(i);
		}
		long end = new GregorianCalendar().getTimeInMillis();
		long endMemory = Runtime.getRuntime().freeMemory();
		System.out.println("StringBuffer Time Taken:" + (end - start));
		System.out.println("StringBuffer Memory used:" + (startMemory - endMemory));
	}

	// StringBuilder mutable and not thread safe
	public static void stringBuilderTest() {
		System.gc();
		long start = new GregorianCalendar().getTimeInMillis();
		long startMemory = Runtime.getRuntime().freeMemory();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10000000; i++) {
			sb.append(":").append(i);
		}
		long end = new GregorianCalendar().getTimeInMillis();
		long endMemory = Runtime.getRuntime().freeMemory();
		System.out.println("StringBuilder Time Taken:" + (end - start));
		System.out.println("StringBuilder Memory used:" + (startMemory - endMemory));
	}
}
