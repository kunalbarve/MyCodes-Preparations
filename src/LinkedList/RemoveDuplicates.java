package LinkedList;

import java.util.HashMap;

public class RemoveDuplicates extends UtilityNodes {
	
	static Node removeDuplicates(Node head){
		if(head == null)
			return head;
		
		Node current = head;
		Node runner = null;
		
		while(current != null){
			runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next; 
				}
			}
			current = current.next;
		}
		return head;
	}
	
	static Node removeDuplicatesAlt(Node head){
		if(head == null)
			return head;
		
		HashMap<Integer, Boolean> map = new HashMap<>();
		Node temp = null,
			first = head;
		
		while(head != null){
			if(map.containsKey(head.data)){
				temp.next = head.next;
			}else{
				map.put(head.data, true);
				temp = head;
			}
			head = head.next;
		}
		
		return first;
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		printNodes(head);
		
		head = removeDuplicatesAlt(head);
		printNodes(head);
	}

}
