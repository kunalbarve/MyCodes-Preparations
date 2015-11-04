package LinkedList;

import java.util.*;

public class Palindrome extends UtilityNodes{
	
	static boolean isPlaindrome(Node head){
		if(head == null)
			return true;
		
		Node slow = head,
			 fast = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null)
			slow = slow.next;
		
		while(slow != null){
			int data = stack.pop();
			if(data != slow.data)
				return false;
			slow = slow.next;
		}
		return true;
	}

	public static void main(String[] args) {
		Node head = createLinkedList();
		printNodes(head);
		
		System.out.println("Given list is plaindrome:"+isPlaindrome(head));
	}

}
