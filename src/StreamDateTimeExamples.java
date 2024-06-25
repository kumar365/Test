import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class StreamDateTimeExamples {

	public static void main(String[] args) {

		// get the second friday of current month
		LocalDate firstDayInCurrentMonth = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
		System.out.println("First Day In Current Month on : " + firstDayInCurrentMonth);
		LocalDate secondFriday = firstDayInCurrentMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
				.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		System.out.println("Second Friday In Current Month : " + secondFriday);
		
		// next occurring Wednesday using
		LocalDate nextWednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		System.out.println("Next Wednesday on : " + nextWednesday);

	}

}
