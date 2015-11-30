package Sorting;

//Average: O(n log(n)) , Worst: O(n*n) Memory: O(log(n))

public class QuickSort extends UtilitySort {
	
	static int partition(int[] input, int start,int end){
		int pivot = input[(start+end)/2];
		
		while(start <= end){
			
			while(input[start] < pivot) start++;
			
			while(pivot < input[end])end--;
			
			if(start <= end){
				int temp = input[start];
				input[start] = input[end];
				input[end] = temp;
				start++;
				end--;
			}
		}
		return start;
	}
	
	static void doQuickSort(int[] input, int start,int end){
		int index = partition(input, start, end);
		printList(input);
		if(start < index-1)
			doQuickSort(input, start, index-1);
		
		if(index < end)
			doQuickSort(input, index, end);
	}

	public static void main(String[] args) {
		
//		String s = "oSzKasAxlaByZ";
//		int[] input = new int[s.length()];
//		for(int i = 0; i< s.length(); i++){
//			input[i] = s.charAt(i);
//		}
		
		int[] input = {1,5,2,88,35,9,12,7};
		System.out.println("Input:");
		printList(input);
		
		doQuickSort(input, 0, input.length-1);
		System.out.println("Output:");
		printList(input);
		
//		String result = "";
//		for(int i = 0; i<input.length;i++){
//			char c = (char)input[i];
//			result = result + c;
//		}
//		System.out.println(result);
	}

}
