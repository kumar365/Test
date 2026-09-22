import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CityFrequency {
    public static void main(String[] args) {
        String[] input = {"bangalore", "pune", "pune, bangalore"};

        Map<String, Long> cityCounts = Arrays.stream(input)
            // Split strings by comma and optional space to separate combined entries
            .flatMap(entry -> Arrays.stream(entry.split(",")))
            // Group by city name and count frequencies
            .map(e -> e.trim())
            .collect(Collectors.groupingBy(
                Function.identity(), 
                Collectors.counting()
            ));

        // Print the result
        cityCounts.forEach((city, count) -> System.out.println(city + " = " + count));
    }
}
