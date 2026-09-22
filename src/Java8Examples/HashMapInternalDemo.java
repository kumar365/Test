package Java8Examples;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapInternalDemo {

    // Custom key designed to force specific collisions
    static class CollidingKey {
        private final String id;
        private final int customizedHash;

        public CollidingKey(String id, int customizedHash) {
            this.id = id;
            this.customizedHash = customizedHash;
        }

        @Override
        public int hashCode() {
            // Forces objects with the same customizedHash into the exact same bucket index
            return this.customizedHash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CollidingKey that = (CollidingKey) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public String toString() {
            return id;
        }
    }

    public static void main(String[] args) {
        // 1. Initial Capacity = 64 (Threshold for Treeification to be allowed)
        // Load Factor = 0.75 (Will resize when 48 elements are total in the map)
        Map<CollidingKey, String> map = new HashMap<>(64, 0.75f);

        System.out.println("=== 1. Normal Insertion & Index Mapping ===");
        // Index calculation: (64 - 1) & hash
        CollidingKey normalKey = new CollidingKey("KeyA", 15); 
        map.put(normalKey, "ValueA");
        System.out.println("KeyA placed in bucket: " + ((64 - 1) & normalKey.hashCode()));

        System.out.println("\n=== 2. Simulating Collision & Treeification ===");
        // We insert 9 items sharing the exact same hashCode (42). 
        // Items 1-8 form a Linked List. Item 9 converts the bucket into a Red-Black Tree.
        for (int i = 1; i <= 9; i++) {
            CollidingKey collisionKey = new CollidingKey("CollisionKey-" + i, 42);
            map.put(collisionKey, "Data-" + i);
            
            int bucketIndex = (64 - 1) & collisionKey.hashCode();
            System.out.printf("Inserted %s into Bucket [%d]. Node structural depth: %d\n", 
                    collisionKey, bucketIndex, i);
        }

        System.out.println("\n=== 3. Reading/Retrieving Data ===");
        // Fast O(log n) tree lookup automatically invoked under the hood
        CollidingKey searchKey = new CollidingKey("CollisionKey-7", 42);
        long startTime = System.nanoTime();
        String result = map.get(searchKey);
        long endTime = System.nanoTime();
        
        System.out.println("Retrieved: " + result + " in " + (endTime - startTime) + " ns.");
    }
}
