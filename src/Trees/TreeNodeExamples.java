package Trees;

import java.util.*;

public class TreeNodeExamples {
	
	//-----------------------------------------------------------------------------------------------------------------
	// Check whether the tree is balanced or not, O(NlogN)
	static int getHeight(TreeNode root){
		if(root == null) return 0;
		return Math.max(getHeight(root.getLeft()), getHeight(root.getRight()))+1;
	}
	
	static boolean isBalanced(TreeNode root){
		if(root == null) 
			return true;
		
		int diff = Math.abs((getHeight(root.getLeft()) - getHeight(root.getRight())));
		if(diff > 1) 
			return false;
		else
			return isBalanced(root.getLeft()) && isBalanced(root.getRight());
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Alternative to check whether the tree is balanced or not, O(N) time and O(H) space
	static int checkHeight(TreeNode root){
		if(root == null) return 0;
		
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == -1) return -1;
		
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == -1) return -1;
		
		int diff = Math.abs(leftHeight - rightHeight);
		if(diff > 1) 
			return -1;
		else 
			return Math.max(leftHeight, rightHeight) + 1;
	}
	
	static boolean isBalancedAlt(TreeNode root){
		if(checkHeight(root) == -1) return false;
		else return true;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	//DFS Search algorithm
	static TreeNode searchDFS(TreeNode root, int data){
		if(root == null) return null;
		
		root.setVisited(true);
		
		for(TreeNode node : root.getAdjacent()){
			if(!node.isVisited()){
				node.setVisited(true);
				if(node.getData() == data)
					return node;
				else
					searchDFS(node, data);
			}
		}
		
		return null;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// BFS Search Algorithm
	static Queue<TreeNode> queue = new LinkedList<TreeNode>();
	static TreeNode searchBFS(TreeNode root, int data){
		if(root == null)
			return null;
		
		root.setVisited(true);
		queue.add(root);
		TreeNode next = null;
		
		while(! queue.isEmpty()){
				next = queue.poll();
				
				for(TreeNode node : next.getAdjacent()){
					if(!node.isVisited()){
						node.setVisited(true);
						if(node.getData() == data)
							return node;
						else
							queue.add(node);
					}
				}
		}
		
		return null;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Create BST, O(N) time  [Alternative: insert node recursive method but that will take O(NlogN) time]
	static TreeNode createMinimalBST(int[] array, int start, int end){
		if(end < start)
			return null;
		
		int mid = (start + end)/2;
		
		TreeNode root = new TreeNode(array[mid]);
		
		root.setLeft(createMinimalBST(array, start, mid -1));
		root.setRight(createMinimalBST(array, mid+1, end));
		
		return root;
	}
	
	static TreeNode createBST(int[] array){
		return createMinimalBST(array, 0, array.length -1);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Check whether two trees are identical or not, O(N) time and O(logN) space because of recursive calls
	static boolean isSameTree(TreeNode p, TreeNode q){
		if(p == null && q == null)
			return true;
		else if(p!= null && q != null){
			if(p.getData() == q.getData())
				return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight()); 
		}else{
			return false;
		}
		
		return false;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Check whether the tree is BST min is -2^31 & max is 2^31 -1, O(N) time and O(logN) space because of recursive calls
	public static boolean checkBSTAlt(TreeNode root, Integer min, Integer max){
		if(root == null) return true;

		if(root.getData() <= min || root.getData() > max) return false;
		
		return checkBSTAlt(root.getLeft(), min, root.getData()) && checkBSTAlt(root.getRight(), root.getData(), max);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// InOrder Traversal, O(N)time and O(N) space
	static ArrayList<TreeNode> inOrderTraversal(TreeNode root){
		TreeNode current = root;
		Stack<TreeNode> inStack = new Stack<TreeNode>();
		ArrayList<TreeNode> inOrderArray = new ArrayList<TreeNode>();
		
		while(!inStack.isEmpty() || current != null){
			if(current != null){
				inStack.push(current);
				current = current.getLeft();
			}else if(!inStack.isEmpty()){
				current = inStack.pop();
				inOrderArray.add(current);
				current = current.getRight();
			}
		}
		return inOrderArray;
	}
	
	// Recursive Approach, O(N) time and O(logN) space
	static void inOrderRecursive(TreeNode root){
		if(root == null)
			return;
		else{
			inOrderRecursive(root.getLeft());
			System.out.print(root.getData()+" ");
			inOrderRecursive(root.getRight());
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// PreOrder traversal, O(N)time and O(N) space
	static ArrayList<TreeNode> preOrderTraversal(TreeNode root){
		ArrayList<TreeNode> preOrderArray = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null)
			return preOrderArray;
		
		stack.push(root);
		
		TreeNode node = null;
		while(!stack.isEmpty()){
			node = stack.pop();
			preOrderArray.add(node);
			
			if(node.getRight() != null)
				stack.push(node.getRight());
			
			if(node.getLeft() != null)
				stack.push(node.getLeft());
		}
		
		return preOrderArray;
	}
	
	//Recursive Approach, O(N) time and O(logN) space
	static void preOrderRecursive(TreeNode root){
		if(root == null)
			return;
		else{
			System.out.print(root.getData()+" ");
			preOrderRecursive(root.getLeft());
			preOrderRecursive(root.getRight());
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Post Order Traversal, O(N)time and O(N) space
	static ArrayList<TreeNode> postOrderTraversal(TreeNode root){
		ArrayList<TreeNode> array = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root == null)
			return array;
		
		stack.push(root);
		
		TreeNode prev = null, curr = null;
		
		while(!stack.isEmpty()){
			curr = stack.peek();
			
			// go down the tree. check if current node is leaf, if so, process it and pop stack, otherwise, keep going down
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr){
				if(curr.getLeft() != null){
					stack.push(curr.getLeft());
				}else if(curr.getRight() != null){
					stack.push(curr.getRight());
				}else{
					curr = stack.pop();
					array.add(curr);
				}
			
			 //go up the tree from left node, need to check if there is a right child, if yes, push it to stack, otherwise, process parent and pop stack
			}else if(curr.getLeft() == prev){
				if(curr.getRight() != null){
					stack.push(curr.getRight());
				}else{
					curr = stack.pop();
					array.add(curr);
				}
				
			//go up the tree from right node, after coming back from right node, process parent node and pop stack. 	
			}else if(curr.getRight() == prev){
				curr = stack.pop();
				array.add(curr);
			}
			prev = curr;
		}
		return array;
	}
	
	//Recursive Approach, O(N) time and O(logN) space
	static void postOrderRecursive(TreeNode root){
		if(root == null)
			return;
		else{
			postOrderRecursive(root.getLeft());
			postOrderRecursive(root.getRight());
			System.out.print(root.getData()+" ");
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	//Build binary tree using in order and post order traversal, O(N) time and O(logN) space
	static TreeNode buildTree(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
		if(inStart > inEnd || postStart > postEnd)
			return null;
		
		int rootValue = postOrder[postEnd];
		TreeNode root = new TreeNode(rootValue);
		
		int k =0;
		for(int i = 0; i< inOrder.length; i++){
			if(inOrder[i] == rootValue){
				k = i;
				break;
			}
		}
		
		root.setLeft(buildTree(inOrder, inStart, k-1, postOrder, postStart, postStart+k-(inStart+1)));
		root.setRight(buildTree(inOrder, k+1, inEnd, postOrder, postStart+k-inStart, postEnd-1));
		
		return root;
	}
	
	static TreeNode createBinary(int[] inorder, int[] postorder){
		int inStart = 0, postStart = 0;
		int inEnd = inorder.length -1;
		int postEnd = postorder.length -1;
		
		return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Flatten the binary tree in linked list. i.e. all left or right are nulls, O(N) time and O(logN) space
	
	static TreeNode flattenTree(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while(node!= null || !stack.isEmpty()){
			if(node.getRight() != null)
				stack.push(node.getRight());
			
			if(node.getLeft() != null){
				node.setRight(node.getLeft());
				node.setLeft(null);
			}else if(! stack.isEmpty()){
				node.setRight(stack.pop());
			}
		}
		return root;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Create N link list for N levels, O(N) time and O(logN) space
	
	static void createLinks(ArrayList<LinkedList<TreeNode>> levelList, TreeNode root, int level){
		if(root == null)
			return;
		
		LinkedList<TreeNode> list = null;
		if(levelList.size() == level){
			list = new LinkedList<TreeNode>();
			levelList.add(list);
		}else{
			list = levelList.get(level);
		}
		
		list.add(root);
		
		createLinks(levelList, root.getLeft(), level+1);
		createLinks(levelList, root.getRight(), level+1);
	}
	
	static ArrayList<LinkedList<TreeNode>> createLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> levelList = new ArrayList<LinkedList<TreeNode>>();
		createLinks(levelList, root, 0);
		return levelList;
	}
	
	//Alternative approach, O(N) time and O(1) space
	static ArrayList<LinkedList<TreeNode>> createListAlt(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		
		if(root != null)
			current.add(root);
		
		while(current.size() > 0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<TreeNode>();
			for(TreeNode node: parents){
				if(node.getLeft() != null)
					current.add(node.getLeft());
				if(node.getRight() != null)
					current.add(node.getRight());
			}
		}
		return result;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Insertion in binary search tree, O(N) time and O(logN) space
	static boolean insertInBST(TreeNode root, int data){
		if(root == null){
			root = new TreeNode(data);
			return true;
		}
		
		if(root.getData() == data){
			return false;
		}else if(data <= root.getData()){
			if(root.getLeft() == null){
				root.setLeft(new TreeNode(data));
				return true;
			}else{
				return insertInBST(root.getLeft(), data);
			}
		}else if(data > root.getData()){
			if(root.getRight() == null){
				root.setRight(new TreeNode(data));
				return true;
			}else{
				return insertInBST(root.getRight(), data);
			}
		}
		return false;
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------
	// Delete a given node in the bst, O(N) time and O(logN) space
	
	static int getMinimumValue(TreeNode node){
		if(node.getLeft() == null)
			return node.getData();
		else
			return getMinimumValue(node.getLeft());
	}
	
	static boolean removeNode(TreeNode parent, TreeNode current, int data){
		int curr = current.getData();
		if(data < curr){
			if(current.getLeft() != null)
				return removeNode(current, current.getLeft(), data);
			else
				return false;
		}else if(data > curr){
			if(current.getRight() != null)
				return removeNode(current, current.getRight(), data);
			else
				return false;
		}else{
			if(current.getLeft()!= null && current.getRight() != null){
				int minValue = getMinimumValue(current.getRight());
				current.setData(minValue);
				removeNode(current, current.getRight(), minValue);
			}else if(parent.getLeft() == current){
				parent.setLeft((current.getLeft() != null)? current.getLeft() : current.getRight());
			}else if(parent.getRight() == current){
				parent.setRight((current.getLeft() != null)? current.getLeft() : current.getRight());
			}
		}
		return true;
	}
	
	static boolean deleteNode(TreeNode root, int data){
		if(root == null)
			return false;
		else if(root.getData() == data){
			TreeNode dummy = new TreeNode(0);
			dummy.setRight(root);
			boolean result = removeNode(dummy, root, data);
			root = dummy.getRight();
			return result;
		}else{
			return removeNode(null, root, data);
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	//Serialize and de serialize a binary tree, O(N) time and O(logN) space
	
	static void serializeTree(TreeNode root, StringBuffer sb){
		if(root == null)
			sb.append("# ");
		else{
			sb.append(root.getData() + " ");
			serializeTree(root.getLeft(), sb);
			serializeTree(root.getRight(), sb);
		}
	}
	
	static TreeNode deserializeTree(String s){
		if(s.isEmpty())
			return null;
		StringTokenizer st = new StringTokenizer(s, " ");
		return getDeserializedNodes(st);
	}
	
	static TreeNode getDeserializedNodes(StringTokenizer st){
		if(!st.hasMoreTokens())
			return null;
		
		String next = st.nextToken(); 
		if(next.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(next));
		root.setLeft(getDeserializedNodes(st));
		root.setRight(getDeserializedNodes(st));
		return root;
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Find successor of the given node in in order traversal Assume you can go to parent
	
	static TreeNode leftMostNode(TreeNode node){
		if(node == null)
			return null;
		
		while(node.getLeft() != null){
			node = node.getLeft();
		}
		return node;
	}
	
	static TreeNode findSuccessor(TreeNode node){
		if(node == null)
			return null;
		
		if(node.getRight() != null){
			return leftMostNode(node.getRight());
		}else{
			TreeNode current = node;
			TreeNode parent = current.getParent();
			while(parent != null && parent.getLeft() != current){
				current = parent;
				parent = parent.getParent();
			}
			return parent;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Find Common Ancestor, O(N) time
	static boolean covers(TreeNode root, TreeNode node){
		if(root == null) return false;
		if(root.getData() == node.getData())
			return true;
		return covers(root.getLeft(), node) || covers(root.getRight(), node);
	}
	
	static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		
		if(root == p || root == q) 
			return root;
		
		boolean isPOnLeft = covers(root.getLeft(), p);
		boolean isQOnLeft = covers(root.getLeft(), q);
		
		if(isPOnLeft != isQOnLeft)
			return root;
		
		TreeNode childSide = isPOnLeft? root.getLeft() : root.getRight();
		return ancestorHelper(childSide, p, q);
	}
	
	static TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root, p) || !covers(root, p))
			return null;
		
		return ancestorHelper(root, p, q);
	}
	
	//-----------------------------------------------------------------------------------------------------------------
	// Check whether the given tree is sub tree of other(identical in shape as well as values), O(N + KM), K is the no of occurrences of r2's root in r1 
	static boolean matchTree(TreeNode r1, TreeNode r2){
		if(r1 == null && r2 == null)
			return true;
		
		if(r1 == null || r2 == null)
			return false;
		
		if(r1.getData() != r2.getData())
			return false;
		
		return matchTree(r1.getLeft(), r2.getLeft()) && matchTree(r1.getRight(), r2.getRight());
	}
	
	static boolean isSubTree(TreeNode r1, TreeNode r2){
		if(r1 == null)
			return false;
		
		if(r1.getData() == r2.getData())
			return matchTree(r1, r2);
		
		return isSubTree(r1.getLeft(), r2) || isSubTree(r1.getRight(), r2);
	}
	
	static boolean containsTree(TreeNode root, TreeNode t){
		if(t == null)
			return true;
		return isSubTree(root, t);
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------
	// Given a node and value find out the paths which will sum to the given value.
	static List<String> paths = new ArrayList<String>();
	
	static void addPath(int[] path, int start, int end){
		StringBuffer sb = new StringBuffer();
		for(int i = start; i<=end; i++){
			sb.append(path[i]);
			if(i != end)
				sb.append("->");
		}
		paths.add(sb.toString());
	}
	
	static void getPath(TreeNode node, int[] path, int sum, int level){
		if(node == null)
			return;
		
		path[level] = node.getData();
		
		int tempSum = 0;
		for(int i = level; i>=0; i--){
			tempSum += path[i];
			if(tempSum == sum){
				addPath(path, i, level);
			}
		}
		
		getPath(node.getLeft(), path, sum, level+1);
		getPath(node.getRight(), path, sum, level+1);
	}
	
	static void findPath(TreeNode node, int data){
		int height = getHeight(node);
		int[] path = new int[height];
		int level = 0;
		getPath(node, path, data, level);
	}
	//-----------------------------------------------------------------------------------------------------------------
	
}
