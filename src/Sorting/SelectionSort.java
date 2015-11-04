package Sorting;

//Best: O(n) Average: O(n*n) Worst: O(n*n) Memory: O(1)
// Find smallest element every time and swap it with current element.

public class SelectionSort extends UtilitySort {

	static int[] doSelectionSort(int[] input){
		if(input == null)
			return null;
		
		if(input.length == 0)
			return input;
		
		for(int i = 0; i< input.length; i++){
			int min = i;
			for(int j = i+1; j<input.length; j++){
				if(input[j] < input[min])
					min = j;
			}	
				int temp = input[i];
				input[i] = input[min];
				input[min] = temp;
				printList(input);
		}
		
		return input;
	}

	public static void main(String[] args) {
		int[] input = {1,5,2,88,35,9,12,7};
		System.out.println("Input:");
		printList(input);
		
		int[] result = doSelectionSort(input);
		System.out.println("Output:");
		printList(result);
	}

}
