package com.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLorgest {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(2);
		list.add(15);
		list.add(20);
		list.add(5);
		list.add(10);
		list.add(25);
		
		int kthHighest = 2;
		
		
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((x, y)->y-x);
		pQueue.addAll(list);//mantain --list
		
		while(--kthHighest>0) {
			System.out.println(pQueue.poll());
		}
		int output = pQueue.peek();
		
		System.out.println(output);
	}
	
	public int getKthHighest(List<Integer> array, int kthHighest){
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((x, y)->y-x);
		pQueue.addAll(array);//mantain --list
		
		while(--kthHighest>0) {
			System.out.println(pQueue.poll());
		}
		int output = pQueue.peek();
		
		System.out.println(output);
		return 0;
	}
	
	List<Integer> mantain(List<Integer> array, int kthHighest){
		//first and second
		int khighestValu  = getKthHighest(array, kthHighest);
		
		return null;
	}
}
