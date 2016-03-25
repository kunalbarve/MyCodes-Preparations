package Trees;

import java.util.*;

public class TreeNode {

	int data = 0;
	TreeNode left, right;
	boolean visited = false;
	
	public TreeNode(){
		left = new TreeNode();
		right = new TreeNode();
	}
	
	public TreeNode(int d){
		data = d;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public List<TreeNode> getAdjacent(){
		List<TreeNode> adjacents = new ArrayList<TreeNode>();
		adjacents.add(getLeft());
		adjacents.add(getRight());
		return adjacents;
	}
	
	public int getSize(){
		return 10;
	}

	public TreeNode getParent() {
		return null;
	}
}
