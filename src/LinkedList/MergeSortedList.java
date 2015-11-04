package LinkedList;

public class MergeSortedList extends UtilityNodes {
	
	static Node mergeList(Node head1, Node head2){
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return head1;
		
		Node first = new Node(0, null),
			 current = first;
		
		while(head1 != null && head2 !=null){
			int data1 = head1.data;
			int data2 = head2.data;
			if(data1 < data2){
				current.next = head1;
				head1 = head1.next;
			}else if(data1 > data2){
				current.next = head2;
				head2 = head2.next;
			}else{
				current.next = head1;
				head1 = head1.next;
				head2 = head2.next;
			}
			current = current.next;
		}
		
		if(head1 == null){
			while(head2 != null){
				current.next = head2;
				current = current.next;
				head2 = head2.next;
			}
		}else if(head2 == null){
			while(head1 != null){
				current.next = head1;
				current = current.next;
				head1 = head1.next;
			}
		}
		
		return first.next;
	}
	
	public static void main(String[] args) {
		Node node4 = new Node(15, null);
		Node node3 = new Node(11, node4);
		Node node2 = new Node(9, node3);
		Node node1 = new Node(6, node2);
		Node head1 = new Node(1, node1);
		
		Node node8 = new Node(12, null);
		Node node7 = new Node(9, node8);
		Node node6 = new Node(7, node7);
		Node node5 = new Node(4, node6);
		Node head2 = new Node(2, node5);
		
		printNodes(head1);
		printNodes(head2);
		
		Node result = mergeList(head1, head2);
		printNodes(result);

	}

}
