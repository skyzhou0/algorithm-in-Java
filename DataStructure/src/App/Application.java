package App;

import java.util.List;

public class Application {
	
	public static void main(String[] args) {
		// Note that arraylist is very efficient for random access if we know the index of the array. 
		// In the meantime, we need to specify the capacity of the arraylist during object instantiation, e.g.
		
		// List<String> listObj = new java.util.ArrayList<>(50000);
		
		// For search operation - Arraylist is better than Linked List.
		// For deletion operation - Arraylist is worser than Linked List.
		// For memory management - Arraylist will be better as it does need to store the pointer reference like in the Linked list.
		
		int[] nums = new int[5];
		
		for(int i = 0; i < nums.length; i++) {
			nums[i] = 2 * i;
		}
		
		// O(1) complexity, random index.
		int num = nums[3];
		System.out.println(num);
		
		// O(N) Linear Search. ---> O(logN) with Binary Search; ---> O(1) with hash table.
		
		for(int i = 0; i< nums.length; i++) {
			if( nums[i] == 4 ) {
				System.out.println("Index found: " + i);
			}
			
		}
		
	}

}
