package LinkedList;

public class UtilityNodes {
	
	static void printNodes(Node head){
		 if(head == null) System.out.println("Empty List");
		 Node temp = head;
		 String listStr = "";
		 while(temp != null){
			if(temp.next == null){
				listStr = listStr+temp.data;
			}else{
				listStr = listStr+temp.data+" -> ";
			}
			temp = temp.next;
		 }
		 System.out.println(listStr);
	 }
	
	static Node createLinkedList(){
		Node node10 = new Node(66, null);
		Node node9 = new Node(66, node10);
		Node node8 = new Node(32, node9);
		Node node7 = new Node(1, node8);
		Node node6 = new Node(4, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(8, node5);
		Node node3 = new Node(4, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(66, node2);
		Node head = new Node(1, node1);
		
		return head;
	}
	
	static Node createCircularLinkedList(){
		Node node10 = new Node(10, null);
		Node node9 = new Node(9, node10);
		Node node8 = new Node(8, node9);
		Node node7 = new Node(7, node8);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node10);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		Node head = new Node(0, node1);
		
		node10.setNext(node4);
		
		return head;
	}
	
	static Node createPalindromeList(){
		Node node10 = new Node(1, null);
		Node node9 = new Node(2, node10);
		Node node8 = new Node(3, node9);
		Node node7 = new Node(4, node8);
		Node node6 = new Node(5, node7);
		Node node5 = new Node(6, node6);
		Node node4 = new Node(5, node5);
		Node node3 = new Node(4, node4);
		Node node2 = new Node(3, node3);
		Node node1 = new Node(2, node2);
		Node head = new Node(1, node1);
		
		return head;
	}
	
}
