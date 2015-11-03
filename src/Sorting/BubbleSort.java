package Sorting;

//Best: O(n) Average: O(n*n) Worst: O(n*n) Memory: O(1)
//It bubbles a smallest or largest element to the end of the array in every iteration. 
//It will just compare two adjacent elements every time.

public class BubbleSort {
	
	static void printList(int[] listToPrint){
		for(int element: listToPrint)
			System.out.print(element+" ");
		System.out.println();
	}
	
	static int[] doBubbleSort(int[] input){
		if(input == null)
			return null;
		
		if(input.length == 0)
			return input;
		
		for(int i = input.length-1; i>0; i--){
			for(int j = 1; j<=i; j++){
				if(input[j-1] > input[j]){
					int temp = input[j-1];
					input[j-1] = input[j];
					input[j] = temp;
				}
				printList(input);
			}
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = {1,5,2,88,35,9,12,7};
		System.out.println("Input:");
		printList(input);
		
		int[] result = doBubbleSort(input);
		System.out.println("Output:");
		printList(result);
	}

}
