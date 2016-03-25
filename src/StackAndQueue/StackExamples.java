package StackAndQueue;

public class StackExamples {
	
	static int[] stack = new int[20];
	static int top = -1;
	
	static void printStack(){
		for(int i = 0; i < stack.length; i++){
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
	
	static void push(int data)throws Exception{
		if(top+1 >= stack.length)
			throw new Exception("Stack is full");
		
		top++;
		stack[top] = data;
	}
	
	static int pop()throws Exception{
		if(top == -1){
			throw new Exception("Stack is empty");
		}
		
		int data = stack[top];
		stack[top] = 0;
		top--;
		return data;
	}
	
	public static void main(String[] args){
		int data  =  20;
		try{
			for(int i = 0; i< 20; i++){
				data++;
				push(data);
				printStack();
			}
			printStack();
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
