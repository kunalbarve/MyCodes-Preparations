package LinkedList;

public class PartitionList extends UtilityNodes{
	
	static Node doPartition(Node head, int data){
		if(head == null)
			return null;
		
		Node start = null,
			 end = null,
			 next = null,
			 startRef = null,
			 endRef = null,
			 center = null;
		
		while(head != null){
			next = head.next;
			head.next = null;
			if(head.data < data){
				if(start == null){
					start = head;
					startRef = start;
				}else{
					start.next = head;
					start = start.next;
				}
			}else if(head.data > data){
				if(end == null){
					end = head;
					endRef = end;
				}else{
					end.next = head;
					end = end.next;
				}
			}else{
				center = head;
			}
			head = next;
		}
		
		if(startRef != null && center != null){
			center.next = endRef;
			start.next = center;
			return startRef;
		}else if(startRef != null){
			start.next = endRef;
			return startRef;
		}else if(center != null){
			center.next = endRef;
			return center;
		}
		
		return endRef;
		
	}
	
	public static void main(String[] args) {
		Node head = createLinkedList();
		printNodes(head);
		
		Node result = doPartition(head, 50);
		printNodes(result);

	}

}
