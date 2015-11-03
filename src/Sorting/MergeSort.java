package Sorting;

//Average & Worst: O(n log(n)) Memory: Depends

public class MergeSort {
	
	static void printList(int[] listToPrint){
		for(int element: listToPrint)
			System.out.print(element+" ");
		System.out.println();
	}
	
	static void merge(int[] input, int[] temp, int start, int middle, int end){
		for(int i = start; i<= end; i++){
			temp[i] = input[i];
		}
		
		int left = start;
		int right = middle+1;
		int current = start;
		
		while(left <= middle && right<= end){
			if(temp[left] <= temp[right]){
				input[current] = temp[left];
				left++;
			}else{
				input[current] = temp[right];
				right++;
			}
			printList(input);
			current++;
		}
		
		int remaining = middle-left;
		for(int i = 0; i<=remaining; i++){
			input[current+i] = temp[left+i];
		}
	}
	
	static void mergeSort(int[] input, int[] temp, int start, int end){
		if(start < end){
			int middle = (start+end)/2;
			mergeSort(input, temp, start, middle);
			mergeSort(input, temp, middle+1, end);
			merge(input, temp, start, middle, end);
		}
	}
	
	static void doMergeSort(int[] input){
		int[] temp = new int[input.length];
		mergeSort(input, temp, 0, input.length-1);
	}

	public static void main(String[] args) {
		int[] input = {1,5,2,88,35,9,12,7};
		System.out.println("Input:");
		printList(input);
		
		doMergeSort(input);
		System.out.println("Output:");
		printList(input);
	}

}
