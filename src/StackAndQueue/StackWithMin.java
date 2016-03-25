package StackAndQueue;

import java.util.*;

public class StackWithMin extends Stack<Integer>{

	private static final long serialVersionUID = 1L;
	Stack<Integer> minStack = new Stack<Integer>();
	
	public StackWithMin(){
		super();
	}
	
	public void push(int val){
		if(val < getMin())
			minStack.push(val);
		super.push(val);
	}
	
	public int getMin(){
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
	public Integer pop(){
		if(!super.isEmpty()){
			int val = super.pop();
			if(val == getMin()){
				minStack.pop();
			}
			return val;
		}
		return -1;
	}
	
	
	
}
