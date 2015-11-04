package LinkedList;

public class NthElementToLast extends UtilityNodes{
	
	// Put runner position-1 steps ahead.
	static Node nthToLastIterative(Node head, int position){
		if(head == null)
			return null;
		
		Node current = head,
			 runner = head;
		
		for(int i = 1; i< position ; i++){
			if(runner.next == null)
				return null;
			runner = runner.next;
		}
		
		while(runner.next != null){
			runner = runner.next;
			current = current.next;
		}
		
		return current;
	}
	
	static Node result = null;
	static int nthToLastRecursive(Node head, int position){
		if(head == null)
			return 0;
		
		int i = nthToLastRecursive(head.next, position)+1;
		if(i == position){
			result = head;
		}
		return i;
	}
	
	static Node findNth(Node head, int position){
		int temp = nthToLastRecursive(head, position);
		if(!(temp > 0))
			return null;
		
		return result;
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		printNodes(head);
		
		Node nthToLast = nthToLastIterative(head, 3);
		System.out.println("3rd element from last is: "+(nthToLast != null ? nthToLast.data : "Node Not present"));
		
		
		Node nthToLastRecursive = findNth(head, 3);
		System.out.println("3rd element from last is: "+(nthToLastRecursive != null ? nthToLastRecursive.data : "Node Not present"));
		
	}

}
