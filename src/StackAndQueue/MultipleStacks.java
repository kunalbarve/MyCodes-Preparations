package StackAndQueue;

public class MultipleStacks {
	
	static int stackSize = 3;
	static int[] stack = new int[stackSize*3];
	static int[] topPointer = {-1, -1, -1};
	
	static void printStack(){
		for(int i = 0; i < stack.length; i++){
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
	
	static int getStackIndex(int stackNum){
		return stackNum*stackSize + topPointer[stackNum];
	}
	
	static void push(int stackNum, int data)throws Exception{
		if(topPointer[stackNum] +1 >= stackSize)
			throw new Exception("Stack "+stackNum+" is Full");
		
		topPointer[stackNum]++;
		stack[getStackIndex(stackNum)] = data;
	}
	
	static int pop(int stackNum)throws Exception{
		if(topPointer[stackNum] == -1)
			throw new Exception("Stack "+stackNum+" is Empty");

		int data = stack[getStackIndex(stackNum)];
		stack[getStackIndex(stackNum)] = 0;
		topPointer[stackNum]--;
		return data;
	}
	
	public static void main(String[] args){
		int data  =  20;
		try{
			for(int i = 0; i< 2; i++){
				for(int j = 0; j<3; j++){
					data++;
					push(j, data);
					printStack();
				}
				
			}
			
			printStack();
			System.out.println("Data:"+pop(0));
			System.out.println("Data:"+pop(1));
			System.out.println("Data:"+pop(2));
			System.out.println("Data:"+pop(2));
			System.out.println("Data:"+pop(2));
			push(0, 30);
			/*System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());
			System.out.println("Data:"+pop());*/
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
