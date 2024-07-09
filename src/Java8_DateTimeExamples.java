import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Java8_DateTimeExamples {

	public static void main(String[] args) {
		getDate();

		// First Day In Current Month
		LocalDate firstDayInCurrentMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
		System.out.println("First Day In Current Month on : " + firstDayInCurrentMonth);

		// get the second Friday of current month
		LocalDate secondFriday = firstDayInCurrentMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
				.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println("Second Friday In Current Month : " + secondFriday);

		// next occurring Wednesday using
		LocalDate nextWednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println("Next Wednesday on : " + nextWednesday);

	}

	public static void getDate() {
		// Used LocalDate API to get the date
		System.out.println("Current Local Date: " + java.time.LocalDate.now());

		// Used LocalTime API to get the time
		System.out.println("Current Local Time: " + java.time.LocalTime.now());

		// Used LocalDateTime API to get both date and time
		System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
	}

}
