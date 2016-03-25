package StackAndQueue;

import java.util.Stack;


public class StackSort {

	static Stack<Integer> sortStack(Stack<Integer> s1){
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(!s1.isEmpty()){
			int temp = s1.pop();
			while(!s2.isEmpty() && s2.peek() > temp){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}
}
