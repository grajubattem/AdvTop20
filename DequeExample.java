package com.algos;

//Java program to demonstrate working of 
//Deque in Java 
import java.util.*; 

public class DequeExample 
{ 
	public static void main(String[] args) 
	{ 
		Deque<String> deque = new LinkedList<String>(); 
		int[] testarray = {4,1,6,2,5,3};
		Arrays.sort(testarray);
		
		System.out.println("search==>"+Arrays.binarySearch(testarray, 2));
		System.out.println("search==>"+Arrays.binarySearch(testarray, 3));
		System.out.println("search==>"+Arrays.binarySearch(testarray, 10));
		System.out.println("search==>"+Arrays.binarySearch(testarray, 15));
		Arrays.fill(testarray, 15);
		
		List listtemp = Arrays.asList(testarray);
		System.out.println(listtemp);
		System.out.println(listtemp.get(0));
		List<Integer> list  = Arrays.asList(1,2,45,6,5,3);
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		System.out.println(list);
		// We can add elements to the queue in various ways 
		deque.add("Element 1 (Tail)"); // add to tail 
		deque.addFirst("Element 2 (Head)"); 
		deque.addLast("Element 3 (Tail)"); 
		deque.push("Element 4 (Head)"); //add to head 
		deque.offer("Element 5 (Tail)"); 
		deque.offerFirst("Element 6 (Head)"); 
		deque.offerLast("Element 7 (Tail)"); 
		deque.poll();

		System.out.println(deque + "\n"); 

		// Iterate through the queue elements. 
		System.out.println("Standard Iterator"); 
		Iterator iterator = deque.iterator(); 
		while (iterator.hasNext()) 
			System.out.println("\t" + iterator.next()); 


		// Reverse order iterator 
		Iterator reverse = deque.descendingIterator(); 
		System.out.println("Reverse Iterator"); 
		while (reverse.hasNext()) 
			System.out.println("\t" + reverse.next()); 

		// Peek returns the head, without deleting 
		// it from the deque 
		System.out.println("Peek " + deque.peek()); 
		System.out.println("After peek: " + deque); 

		// Pop returns the head, and removes it from 
		// the deque 
		System.out.println("Pop " + deque.pop()); 
		System.out.println("After pop: " + deque); 

		// We can check if a specific element exists 
		// in the deque 
		System.out.println("Contains element 3: " + 
						deque.contains("Element 3 (Tail)")); 

		// We can remove the first / last element. 
		deque.removeFirst(); 
		deque.removeLast(); 
		System.out.println("Deque after removing " + 
							"first and last: " + deque); 

	} 
} 
