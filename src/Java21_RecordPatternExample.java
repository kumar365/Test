
record Point(int x, int y) {
}
// 2. Record Patterns (JEP 440)
// Record patterns allow for pattern matching on record components directly 
// within instanceof and switch expressions, simplifying data extraction.
public class Java21_RecordPatternExample {
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		Object obj = new Point(10, 20);

		if (obj instanceof Point(int x, int y)) {
			System.out.println("Point coordinates: x=" + x + ", y=" + y);
		}
	}
}
