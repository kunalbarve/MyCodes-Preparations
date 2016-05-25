package LinkedList;

public class ReverseHalfLinkedList {

	static Node reverseList(Node head) {
		Node temp = null, nextNode = null, current = head;
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(temp);
			temp = current;
			current = nextNode;
		}
		return temp;
	}

	static Node isPlaindrome(Node head) {
		if (head == null)
			return head;

		Node slow = head, fast = head, last = null;

		while (fast != null && fast.next != null) {
			last = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// if(fast != null){
		// last = slow;
		// slow = slow.next;
		// }

		Node temp = reverseList(slow);
		last.next = temp;
		return head;
	}

	static void printList(Node head) {
		if (head == null)
			System.out.println("Empty List");
		;
		Node temp = head;
		String listStr = "";
		while (temp != null) {
			if (temp.getNext() == null) {
				listStr = listStr + temp.getData();
			} else {
				listStr = listStr + temp.getData() + " -> ";
			}
			temp = temp.getNext();
		}
		System.out.println(listStr);
	}

	public static void main(String[] args) {
		// Node node4 = new Node(21, null);
		Node node3 = new Node(4, null);
		Node node2 = new Node(3, node3);
		Node node1 = new Node(2, node2);
		Node head = new Node(1, node1);

		printList(head);

		Node temp = isPlaindrome(head);

		printList(temp);

	}
}