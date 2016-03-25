package StackAndQueue;

import java.util.Stack;


public class QueueUsingTwoStacks {

	Stack<Object> newest, oldest;
	
	public QueueUsingTwoStacks(){
		newest = new Stack<Object>();
		oldest = new Stack<Object>();
	}
	
	public void queue(Object value){
		newest.push(value);
	}
	
	public void shiftElements(){
		if(oldest.isEmpty()){
			while(!newest.isEmpty()){
				oldest.push(newest.pop());
			}
		}
	}
	
	public Object peek(){
		shiftElements();
		return oldest.peek();
	}
	
	public Object deque(){
		shiftElements();
		return oldest.pop();
	}
}
