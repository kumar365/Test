package JavaConcurrencyExamples;
import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List < Integer > numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //make a square of each value using parallel stream
        numbers.parallelStream()
            .forEach(i -> {
                System.out.println(Thread.currentThread().getName() + " - " + i);
            });
    }
}