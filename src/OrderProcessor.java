import java.util.*;
import java.util.stream.Collectors;

class Item {
	private String name;
	private int quantity;

	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
}

class Order {
	private List<Item> items;

	public Order(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}
}

public class OrderProcessor {
	public static Map<String, Integer> getTotalItemQuantities(List<Order> orders) {
		if (orders == null)
			return Collections.emptyMap();

		return orders.stream().filter(Objects::nonNull) // Filter out null orders
				.flatMap(order -> order.getItems().stream()) // Flatten List<Item> to Stream<Item>
				.filter(Objects::nonNull) // Filter out null items
				.collect(Collectors.groupingBy(Item::getName, // Group by item name (Key)
						Collectors.summingInt(Item::getQuantity) // Downstream collector to sum quantities (Value)
				));
	}

	public static void main(String[] args) {
		List<Order> orders = new ArrayList<Order>();
		List<Item> items1 = new ArrayList<Item>();
		List<Item> items2 = new ArrayList<Item>();
		Item item1= new Item("A1", 10);
		items1.add(item1);
		Item item2= new Item("A2", 20);
		items1.add(item2);
		Item item3= new Item("A3", 30);
		items1.add(item3);
		Item item4= new Item("A4", 40);
		items1.add(item4);	
		
		Order order1 = new Order(items1);
		
		orders.add(order1);
		
		Item item11= new Item("B1", 10);
		items2.add(item11);
		Item item21= new Item("B2", 20);
		items2.add(item21);
		Item item31= new Item("B3", 30);
		items2.add(item31);
		Item item41= new Item("B4", 40);
		items2.add(item41);	
		
		Order order2 = new Order(items2);
		
		orders.add(order2);
		
		Map<String, Integer> map=getTotalItemQuantities(orders);
		
		map.forEach((key, value) -> System.out.println(key + " : " + value));
	}
}