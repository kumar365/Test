
import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;
        remove(node);
        insertAtTop(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> node = map.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            insertAtTop(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            insertAtTop(newNode);
        }
    }

    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtTop(Node<K, V> node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    public static void main(String[] args) {
		// Create an LRU cache with a capacity of 3
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        System.out.println("Running sequential tests...");

        // 1. Test basic insertion and retrieval
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        
        assert "One".equals(cache.get(1)) : "Key 1 should return 'One'";
        assert "Two".equals(cache.get(2)) : "Key 2 should return 'Two'";
        assert "Three".equals(cache.get(3)) : "Key 3 should return 'Three'";

        // 2. Test eviction policy
        // Cache state before: [3, 2, 1] (1 is least recently used)
        // Accessing 1 makes it most recent: [1, 3, 2]
        cache.get(1); 
        
        // This put should evict key 2 (now the least recently used)
        cache.put(4, "Four"); 

        assert cache.get(2) == null : "Key 2 should have been evicted";
        assert "One".equals(cache.get(1)) : "Key 1 should still be present";
        assert "Four".equals(cache.get(4)) : "Key 4 should be present";

        // 3. Test value replacement (updates should not change count, but move item to top)
        // Current state: [4, 1, 3] (3 is least recently used)
        cache.put(3, "New Three"); // updates 3, moves to top: [3, 4, 1]
        cache.put(5, "Five");     // exceeds capacity, evicts 1

        assert cache.get(1) == null : "Key 1 should have been evicted";
        assert "New Three".equals(cache.get(3)) : "Key 3 should reflect updated value";

        System.out.println("All sequential tests passed successfully!");

	}

}
