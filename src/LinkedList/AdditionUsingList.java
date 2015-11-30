package LinkedList;

public class AdditionUsingList extends UtilityNodes{
	
	// head is unit digit
	static Node performAddition(Node list1, Node list2, int carry){
		if(list1 == null && list2 == null && carry == 0)
			return null;
		
		Node result = new Node(0, null);
		
		int value = carry;
		if(list1 != null)
			value += list1.data;
		if(list2 != null)
			value += list2.data;
		
		result.data = value%10;
		carry = value/10;
		
		if(list1 != null || list2 != null){
			Node nextNode = performAddition((list1 != null ? list1.next : null), (list2 != null ? list2.next : null), carry);
			result.next = nextNode;
		}
		return result;
	}
	
	//head is not unit digit
	static int carry = 0;
	static Node paddList(Node head, int positions){
		if(positions == 0)
			return head;
		
		for(int i = 0; i< positions; i++){
			Node newNode = new Node(0, head);
			head = newNode;
		}
		return head;
	}
	
	static Node doAddition(Node list1, Node list2){
		if(list1 == null && list2 == null && carry == 0)
			return null;
		
		Node result = doAddition(list1.next, list2.next);
		
		int val = carry;
		if(list1 != null) val += list1.data;
		if(list2 != null) val += list2.data;
		
		Node sum = new Node(val%10, result);
		
		carry = val/10;
		
		return sum;
	}
	
	static Node performForwardAddition(Node list1, Node list2){
		int size1 = getSize(list1);
		int size2 = getSize(list2);
		int diff =  Math.abs(size1-size2);
		if(size1 > size2)
			list2 = paddList(list2, diff);
		else
			list1 = paddList(list1, diff);
		
		printNodes(list1);
		printNodes(list2);
		
		Node sum = doAddition(list1, list2);
		
		if(carry != 0){
			Node newNode = new Node(carry, sum);
			sum = newNode;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Node node4 = new Node(5, null);
//		Node node3 = new Node(1, node4);
//		Node node2 = new Node(9, node3);
//		Node node1 = new Node(6, node2);
//		Node head1 = new Node(1, node1);
		
		Node node8 = new Node(5, null);
//		Node node7 = new Node(9, node8);
//		Node node6 = new Node(7, node7);
//		Node node5 = new Node(4, node6);
//		Node head2 = new Node(2, node5);
		
		printNodes(node4);
		printNodes(node8);
		
		Node result = performAddition(node4, node8, 0);
		printNodes(result);
		
//		Node result2 = performForwardAddition(head1, head2);
//		printNodes(result2);

	}

}
