package Sorting;

//Best: O(n) Average: O(n*n) Worst: O(n*n)
// Compare current element with all the previous elements and put current at specific sorted position.

public class InsertionSort {
	
	static void printList(int[] listToPrint){
		for(int element: listToPrint)
			System.out.print(element+" ");
		System.out.println();
	}
	
	static int[] doInsertionSort(int[] input){
		if(input == null)
			return null;
		
		if(input.length == 0)
			return input;
		
		for(int i = 0; i< input.length; i++){
			int current = input[i];
			int j = i;
			while(j>0 && input[j-1] > current){
				printList(input);
				input[j] = input[j-1];
				j--;
			}
			input[j] = current;
		}
		
		return input;
	}

	public static void main(String[] args) {
		int[] input = {1,5,2,88,35,9,12,7};
		System.out.println("Input:");
		printList(input);
		
		int[] result = doInsertionSort(input);
		System.out.println("Output:");
		printList(result);
	}

}
