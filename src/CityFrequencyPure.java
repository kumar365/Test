import java.util.HashMap;
import java.util.Map;

public class CityFrequencyPure {
    public static void main(String[] args) {
        String[] input = {"bangalore", "pune", "pune, bangalore"};
        Map<String, Integer> cityCounts = new HashMap<>();

        // Iterate through each element in the input array
        for (String entry : input) {
            // Split entries by comma and remove any leading/trailing spaces
            String[] cities = entry.split(",");
            
            for (String city : cities) {
                String cleanCity = city.trim();
                
                // Update the count in the map
                if (cityCounts.containsKey(cleanCity)) {
                    cityCounts.put(cleanCity, cityCounts.get(cleanCity) + 1);
                } else {
                    cityCounts.put(cleanCity, 1);
                }
            }
        }

        // Print the final counts
        for (Map.Entry<String, Integer> entry : cityCounts.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
