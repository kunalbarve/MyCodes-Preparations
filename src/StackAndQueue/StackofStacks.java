package StackAndQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StackofStacks {
	int capacity;
	List<Stack<Integer>> stacks = new ArrayList<>();
	
	public StackofStacks(int c){
		capacity = c;
	}
	
	public Stack<Integer> getLastStack(){
		if(stacks.size() == 0) return null;
		return stacks.get(stacks.size() -1);
	}
	
	public void push(int data){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack != null && lastStack.size() < capacity){
			lastStack.push(data);
		}else{
			Stack<Integer> newStack = new Stack<>();
			newStack.push(data);
			stacks.add(newStack);
		}
	}
	
	public int pop(){
		Stack<Integer> lastStack = getLastStack();
		if(lastStack == null){
			System.out.println("Empty stacks");
			return -1;
		}
		
		int data = lastStack.pop();
		if(lastStack.size() == 0)
			stacks.remove(lastStack);
		return data;
	}
	
	public int removeAtIndex(int stackIndex){
		return shiftStacks(stackIndex, true);
	}
	
	public int shiftStacks(int stackIndex, boolean removeTop){
		Stack<Integer> selectedStack = stacks.get(stackIndex);
		int removed_data = 0;
		
		if(removeTop) removed_data = selectedStack.pop();
		else {
			removed_data = selectedStack.get(0);
			selectedStack.remove(0);
		}
		
		if(selectedStack.size() == 0) stacks.remove(selectedStack);
		else if(stacks.size() > stackIndex+1){
			int val = shiftStacks(stackIndex+1, false);
			selectedStack.push(val);
		}
		return removed_data;
	}
}
