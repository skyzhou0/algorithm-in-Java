package LinkedList;

// This is a copy of alazsholczer course on Creating Linked List.
// Perhaps, one should just use the Linkedlist from java.util which will be much easier.

public class App {
	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		
		list.insert(10);
		list.insert(-2);
		list.insert(3);
		list.insert(100);
		
		list.traverseList();
	}

}
