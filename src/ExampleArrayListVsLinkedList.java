import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class ExampleArrayListVsLinkedList {
	public static void main(String[] args) {
		arrayListExample();
		linkedListExample();
	}

	public static void arrayListExample() {
		// Creating an ArrayList of Integer type
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		// Appending the new elements at the end of the list using add () method via for
		// loops
		for (int i = 1; i <= 5; i++) {
			arrayList.add(i);
		}
		// Printing the ArrayList
		System.out.println("ArrayList::" + arrayList);

		// Removing an element at index 3 from the ArrayList using remove() method
		arrayList.remove(3);

		// Printing the ArrayList after removing the element
		System.out.println("ArrayList after removing the element at index 3::" + arrayList);
	}

	public static void linkedListExample() {
		// Creating an object of the class linked list
		LinkedList<String> linkedList = new LinkedList<String>();

		// Adding the elements to the object created using add() and addLast() method
		// Custom input elements
		linkedList.add("B");
		linkedList.add("C");

		System.out.println("LinkedList::" + linkedList);

		linkedList.addFirst("A");
		System.out.println("LinkedList after addFirst(A)::" + linkedList);

		linkedList.addLast("D");
		System.out.println("LinkedList after addLast(\"D\")::" + linkedList);

		// Removing elements from the List object using remove() and removeFirst()
		// method
		linkedList.remove("B");
		System.out.println("Linked list after remove(\"B\"): " + linkedList);

		linkedList.removeFirst();
		System.out.println("Linked list after removeFirst(): " + linkedList);

		linkedList.removeLast();
		System.out.println("Linked list after removeLast(): " + linkedList);

		linkedList.add("F");
		System.out.println("LinkedList::" + linkedList);

		linkedList.set(1, "G");// set(int index, Object element)

		// Using set() method to replace F with G
		System.out.println("LinkedList replace F with G using set(1, \"G\")::" + linkedList);

		System.out.println("Does the List contains \"G\": " + linkedList.contains("G"));

		System.out.println("The first occurrence of \"C\" is at index:" + linkedList.indexOf("C")); // index of element
		System.out.println("The first occurrence of \"F\" is at index:" + linkedList.indexOf("F")); // -1 if element not
																									// found

		linkedList.add("H");
		linkedList.add("K");

		System.out.println("LinkedList::" + linkedList);
		// poll() or pollFirst() retrieves and removes the first element of the list
		System.out.println("First element of the list removed using pollFirst(): " + linkedList.pollFirst());
		System.out.println("LinkedList::" + linkedList);

		// pollLast() retrieves and removes the last element of the list
		System.out.println("Last element of the list removed using pollLast(): " + linkedList.pollLast());
		System.out.println("LinkedList::" + linkedList);

		// push an element at the starting of the list similar to addFirst()
		linkedList.push("A");
		System.out.println("LinkedList after push(\"A\")::" + linkedList);

		// retrieves and removes an element at the starting of the list
		linkedList.pop();
		System.out.println("LinkedList after pop()::" + linkedList);

		// peek() or peekFirst() Prints 1st element
		System.out.println("First element of the list : " + linkedList.peekFirst());

		// peek at the tail of the list prints last element of the list
		System.out.println("Last element of the list : " + linkedList.peekLast());

		// Setting the ListIterator at a specified position
		ListIterator<String> listIterator = linkedList.listIterator(2);

		// Iterating through the created list from the forward direction
		System.out.println("The list is as follows:");
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		// Iterating through the created list from the backward direction 
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		// Clearing the list
		linkedList.clear();
		System.out.println("LinkedList::" + linkedList);
	}

}
