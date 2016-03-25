package LinkedList;

import java.util.Hashtable;
import java.util.Stack;


public class NodeExamples{
	
	//For forward addition of two elements only.
	static int carry = 0;
	
	static void printList(Node head){
		 if(head == null) System.out.println("Empty List");;
		 Node temp = head;
		 String listStr = "";
		 while(temp != null){
			if(temp.getNext() == null){
				listStr = listStr+temp.getData();
			}else{
				listStr = listStr+temp.getData()+" -> ";
			}
			temp = temp.getNext();
		 }
		 System.out.println(listStr);
	 }
	 
	static void removeDuplicates(Node head){
		Hashtable<Integer, Boolean> nodeTable = new Hashtable<Integer, Boolean>();
		Node temp = null;
		while(head != null){
			if(nodeTable.containsKey(head.getData())){
				temp.setNext(head.getNext());
			}else{
				nodeTable.put(head.getData(), true);
				temp = head;
			}
			head = head.getNext();
		}
	}
	
	static Node removeDuplicateNodesWithoutBuffer(Node head){
		if(head == null) return head;
		Node current = head;
		Node runner = null;
		while(current != null){
			runner = current;
			while(runner.getNext() != null){
				if(runner.getNext().getData() == current.getData()){
					runner.setNext(runner.getNext().getNext());
				}else{
					runner = runner.getNext(); 
				}
			}
			current = current.getNext();
		}
		return head;
	}
	
	static int getSize(Node head){
		if(head == null) return 0;
		Node temp = head;
		int count = 0;
		while(temp != null){
			count++;
			temp = temp.getNext();
		}
		return count;
	}
	
	static int nthToLastRecursive(Node head, int position){
		if(head == null) return 0;
		int i = nthToLastRecursive(head.getNext(), position)+1;
		if(i == position){
			System.out.println("Element at "+position+" positions from the end is: "+head.getData());
		}
		return i;
	}
	
	static Node nthToLastIterative(Node head, int position){
		 Node starter = head;
		 Node runner = head;
	 
		for(int i =1; i<position; i++){
			if(runner.getNext() == null) return null;
			runner = runner.getNext();
		}
		
		while(runner.getNext() != null){
			runner = runner.getNext();
			starter = starter.getNext();
		}
		
		return starter;
	}
	
	static boolean deleteNode(Node nodeToDelete){
		if(nodeToDelete == null || nodeToDelete.getNext() == null) return false;
		
		Node nextNode = nodeToDelete.getNext();
		nodeToDelete.setData(nextNode.getData());
		nodeToDelete.setNext(nextNode.getNext());
		return true;
	}
	
	static Node deleteNodeWithData(Node head, int data){
		if(head == null) return head;
		
		if(head.getData() == data){
			return head.getNext();
		}
		
		Node temp = head;
		
		while(temp.getNext() != null){
			if(temp.getNext().getData() == data){
				temp.setNext(temp.getNext().getNext());
				//If we want to remove all elements than remove the below return statement.
				return head;
			}
			temp = temp.getNext();
		}
		System.out.println("No node has given data");
		return head;
	}
	
	static Node partitionList(Node head, int value){
		Node beforeStart = null, afterStart = null, nextNode = null;
		
		while(head != null){
			nextNode = head.getNext();
			if(head.getData() < value){
				head.setNext(beforeStart);
				beforeStart = head;
			}else{
				head.setNext(afterStart);
				afterStart = head;
			}
			head = nextNode;
		}
		
		if(beforeStart == null){
			return afterStart;
		}
		
		head = beforeStart;
		while(beforeStart.getNext() != null){
				beforeStart = beforeStart.getNext();
		}
		beforeStart.setNext(afterStart);
		return head;
	}
	
	static Node addTwoElements(Node list1, Node list2, int carry){
		if(list1== null && list2==null && carry==0) return null;
		
		Node result = new Node(0, null);
		
		int val = carry;
		if(list1 != null) val += list1.getData();
		if(list2 != null) val += list2.getData();
		
		result.setData(val%10);
		
		if(list1 != null || list2 != null){
			Node nextNode = addTwoElements(list1 == null? null : list1.getNext(),
											list2 == null? null : list2.getNext(),
											val >= 10? 1: 0);
			
			result.setNext(nextNode);
		}
		
		return result;
	}
	
	static Node padList(Node head, int padding){
		Node temp = head;
		for(int i = 0; i< padding; i++){
			Node newNode = new Node(0, null);
			newNode.setNext(temp);
			temp = newNode;
		}
		return temp;
	}
	
	static Node insertBefore(Node head, int data){
		Node newNode = new Node(data, null);
		if(head != null){
			newNode.setNext(head);
		}
		return newNode;
	}
	
	static Node performAddition(Node list1, Node list2){
		if(list1 == null && list2 == null && carry==0) return null;
		
		Node result = performAddition(list1.getNext(), list2.getNext());
		
		int val = carry;
		if(list1 != null) val += list1.getData();
		if(list2 != null) val += list2.getData();
		carry = val/10;
		
		Node sum = insertBefore(result, val%10);
		
		return sum; 
	}
	
	static Node addTwoElementsForward(Node list1, Node list2){
		int length1 = getSize(list1);
		int length2 = getSize(list2);
		
		if(length1 < length2){
			list1 = padList(list1, length2-length1);
		}else if(length1 > length2){
			list2 = padList(list2, length1-length2);
		}
		
		printList(list1);
		printList(list2);
		
		Node result = performAddition(list1, list2);
		
		if(carry == 0){
			return result;
		}
		
		Node firstNode = insertBefore(result, carry);
		carry = 0;
		return firstNode;
	}
	
	static Node startOfLoop(Node head){
		Node slow = head;
		Node fast = head;
		
		while(fast.getNext() != null && fast != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast) break;
		}
		
		if(fast == null || fast.getNext() == null){
			System.out.println("There is no loop in the cycle");
			return null;
		}
		
		slow = head;
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		
		return fast;
	}
	
	static Node reverseList(Node head){
		if(head == null){
			System.out.println("Empty List");
		}
		
		Node temp = null, nextNode = null, current = head;
		while(current != null){
			/*temp = insertBefore(temp, head.getData());
			head = head.getNext();*/
			
			nextNode = current.getNext();
			current.setNext(temp);
			temp = current;
			current = nextNode;
		}
		
		return temp;
	}
	
	static void displayReverseList(Node head){
		if(head == null){
			return;
		}else{
			displayReverseList(head.getNext());
			System.out.print(head.getData()+" -> ");
		}
	}
	
	static boolean isPalindrome(Node head){
		Node slow = head, fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.getNext() != null){
			stack.push(slow.getData());
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		
		if(fast != null) slow = slow.getNext();
		
		while(slow != null){
			int value = stack.pop().intValue();
			if(value != slow.getData())
				return false;
			slow = slow.getNext();
		}
		return true;
	}
	
	//-----------------------------------------------------------------------------------------------
		// Merge two sorted list
		static Node mergeSortList(Node head1, Node head2){
			if(head1 == null)
				return head2;
			if(head2== null)
				return head1;
			
			Node first = new Node(0, null);
			Node temp = first;
			
			while(head1!=null && head2!=null){
				if(head1.getData() < head2.getData()){
					temp.setNext(head1);
					head1 = head1.getNext();
				}else if(head1.getData() > head2.getData()){
					temp.setNext(head2);
					head2 = head2.getNext();
				}else if(head1.getData() == head2.getData()){
					temp.setNext(head1);
					head1 = head1.getNext();
					head2 = head2.getNext();
				}
				temp = temp.getNext();
			}
			
			if(head1 == null){
				while(head2!=null){
					temp.setNext(head2);
					head2 = head2.getNext();
					temp = temp.getNext();
				}
			}
			
			if(head2 == null){
				while(head1!=null){
					temp.setNext(head1);
					head1 = head1.getNext();
					temp = temp.getNext();
				}
			}
			
			return first.getNext();
		}
		
		
		
		//-----------------------------------------------------------------------------------------------
		
	
	public static void main(String[] args){
		Node node10 = new Node(12, null);
		Node node9 = new Node(45, node10);
		Node node8 = new Node(32, node9);
		Node node7 = new Node(11, node8);
		Node node6 = new Node(4, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(8, node5);
		Node node3 = new Node(4, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(66, node2);
		Node head = new Node(1, node1);
		
		printList(head);
		
		/*//Remove Duplicates without Buffer
		head = removeDuplicateNodesWithoutBuffer(head);
		printList(head);*/
		
		
		/*//Remove Duplicates with Buffer
		removeDuplicates(head);
		printList(head);*/
		
		
		/*//Find the nth element from the end using recursive approach. O(n) space
		int listSize = getSize(head);
		System.out.println("List Size: "+listSize);
		int position = 9;
		if(position > listSize){
			System.out.println("Position can not be larger than list size.");
		}else{
			nthToLastRecursive(head, position);
		}*/
		
		
		/*// Find the nth element from last using iterative approach. optimal solution. O(n) time & O(1) space
		int listSize = getSize(head);
		System.out.println("List Size: "+listSize);
		int position = 1;
		if(position > listSize || position == 0){
			System.out.println("Position can not be larger than list size & needs to be greater than 0.");
		}else{
			Node result = nthToLastIterative(head, position);
			System.out.println("Element at "+position+" positions from the end is: "+result.getData());
		}*/
		
		
		/*//Delete a given node from the linked list.
		if(deleteNode(node10))
			System.out.println("Node deleted successfully");
		else
			System.out.println("Node is null or the last node");
		printList(head);*/
		
		
		/*//Delete a given node given the head node and data of the node to delete.
		Node result = deleteNodeWithData(head, 4);
		printList(result);*/
		
		
		/*// Partition the list around the given value.
		Node result = partitionList(head, 30);
		printList(result);*/
		
		
		/*// Add two elements where unit digit is starting at head of the list.
		Node nodez = new Node(9, null);
		Node nodea = new Node(9, nodez);
		Node nodeb = new Node(1, nodea);
		Node nodec = new Node(9, nodeb);
		Node noded = new Node(5, null);
		Node nodee = new Node(8, noded);
		Node nodef = new Node(4, nodee);
		printList(nodec);
		printList(nodef);
		Node result = addTwoElements(nodec, nodef, 0);
		printList(result);*/
		
		
		/*// Add two elements where unit digit is end of the list.
		Node nodez = new Node(9, null);
		Node nodea = new Node(9, nodez);
		Node nodeb = new Node(1, nodea);
		Node nodec = new Node(9, nodeb);
		Node noded = new Node(5, null);
		Node nodee = new Node(8, noded);
		Node nodef = new Node(4, nodee);
		printList(nodec);
		printList(nodef);
		Node result = addTwoElementsForward(nodec, nodef);
		printList(result);*/
		
		
		/*//Find the start of the loop. Suppose slow will take k steps and fast will take 2k steps. So loopsize-k steps will gives the start.
		node10.setNext(head);
		Node result = startOfLoop(head);
		if(result != null) System.out.println("Starting node of the lopp is: "+result.getData());*/
		
		
		/*// Reverse a given linked list
		Node result = reverseList(head);
		if(result != null) printList(result);*/
		
		
		/*//Print the list in reverse.
		displayReverseList(head);*/
		
		
		/*//Iterative approach to check whether a given list is a palindrom or not.
		Node nodez = new Node(5, null);
		Node nodey = new Node(4, nodez);
		Node nodea = new Node(1, nodey);
		Node nodeb = new Node(1, nodea);
		Node nodec = new Node(4, nodeb);
		Node noded = new Node(5, nodec);
		printList(noded);
		if(isPalindrome(noded)) System.out.println("A Palindrome");
		else System.out.println("Not a Palindrome");*/
		
		Node nodez = new Node(13, null);
		Node nodey = new Node(11, nodez);
		Node nodea = new Node(9, nodey);
		Node nodeb = new Node(7, nodea);
		Node nodec = new Node(3, nodeb);
		Node head1 = new Node(1, nodec);
		
		Node nodeo = new Node(15, null);
		Node nodep = new Node(8, nodeo);
		Node nodeq = new Node(2, nodep);
		Node head2 = new Node(1, nodeq);
		
		printList(head1);
		printList(head2);
		
		Node result = mergeSortList(head1, head2);
		printList(result);
	}
}