package LinkedList;

public class LoopInList extends UtilityNodes {

	static boolean isLoopExist(Node head){
		if(head == null)
			return false;
		
		Node slow = head,
			 fast = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return false;
		
		return true;
	}
	
	static Node getStartOfLoop(Node head){
		if(head == null)
			return null;
		
		Node slow = head,
			 fast = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null)
			return null;
		
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		Node head = createCircularLinkedList();
		//printNodes(head);
		
//		System.out.println("Is loop is there:"+ isLoopExist(head));
		
		Node result = getStartOfLoop(head);
		System.out.println("Start of loop:"+(result != null ? result.data : "Loop doesn't exist."));

	}

}
