package LinkedList;

public class Node {
	Node next;
	int data;
	
	public Node(int d, Node n){
		data = d;
		next = n;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	
}
