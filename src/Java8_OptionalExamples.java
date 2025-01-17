import java.util.Optional;

public class Java8_OptionalExamples {
	// Main Method
	public static void main(String[] args) {
		String[] words = new String[10];

		// It returns an empty instance of Optional class
		Optional<String> empty = Optional.empty();
		System.out.println(empty);

		words[0] = "kumar";
		// It returns a non-empty Optional
		Optional<String> value = Optional.of(words[0]);// null pointer exception if value is empty/not exist
		System.out.println(value);

		// It returns value of an Optional.If value is not present, it throws an
		// NoSuchElementException
		System.out.println(value.get());

		// It returns hashCode of the value
		System.out.println(value.hashCode());

		// It returns true if value is present, otherwise false
		System.out.println(value.isPresent());

		// words[5] = "Pradeep";
		Optional<String> checkNull = Optional.ofNullable(words[5]);
		if (checkNull.isPresent()) {
			System.out.print(words[5].toLowerCase());
		} else
			System.out.println("word is null");

		// create a Optional
		Optional<Integer> optional = Optional.of(9455);

		// print value
		System.out.println("Optional: " + optional);

		// orElse value
		System.out.println("Value by orElse" + "(100) method: " + optional.orElse(100));

		// create a Optional
		Optional<Integer> op1 = Optional.empty();

		// print value
		System.out.println("Optional: " + op1);

		try {
			// orElse value
			System.out.println("Value by orElse" + "(100) method: " + op1.orElse(100));
		} catch (Exception e) {
			System.out.println(e);
		}
		// create a Optional
		Optional<Integer> op2 = Optional.of(9455);

		// print value
		System.out.println("Optional: " + op2);

		// apply ifPresentOrElse
		op2.ifPresentOrElse((val) -> {
			System.out.println("Value is present, its: " + val);
		}, () -> {
			System.out.println("Value is empty");
		});
		// create a Optional
		Optional<Integer> op3 = Optional.empty();

		// print value
		System.out.println("Optional: " + op3);

		try {

			// apply ifPresentOrElse
			op3.ifPresentOrElse((val) -> {
				System.out.println("Value is present, its: " + val);
			}, () -> {
				System.out.println("Value is empty");
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		// create a Optional
		Optional<Integer> op4 = Optional.of(9455);

		// print supplier
		System.out.println("Optional: " + op4);

		// or supplier
		System.out.println("Optional by or(() ->" + " Optional.of(100)) method: " + op4.or(() -> Optional.of(100)));
		// create a Optional
		Optional<Integer> op5 = Optional.empty();

		// print supplier
		System.out.println("Optional: " + op5);

		try {

			// or supplier
			System.out.println("Optional by or(() ->" + " Optional.of(100)) method: " + op5.or(() -> Optional.of(100)));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
