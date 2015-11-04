package LinkedList;

public class DeleteNode extends UtilityNodes{
	
	static boolean deleteGivenNode(Node node){
		if(node == null || node.next == null)
			return false;
		
		Node nextNode = node.next;
		node.data = nextNode.data;
		node.next = nextNode.next;
		return true;
	}
	
	static Node deleteNodeWithData(Node head, int data){
		if(head == null)
			return null;
		
		if(head.data == data)
			return head.next;
		
		Node temp = head;
		while(temp.next != null){
			if(temp.next.data == data)
				temp.next = temp.next.next;
			else
				temp = temp.next;
		}
		return head;
	}
	
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		
		printNodes(head);
		
		/*boolean result = deleteGivenNode(node5);
		if(result == true)
			printNodes(head);
		else
			System.out.println("Unable to delete the given node");
		 */
		
		Node result = deleteNodeWithData(head, 66);
		printNodes(result);
		
	}

}
