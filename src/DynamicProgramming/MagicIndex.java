package DynamicProgramming;
public class MagicIndex {
	
	//------------------------------------------------------------------------------------
	// Get Magic index if array is sorted and all elements are distinct
	static int getMagicDistinct(int[] array, int start, int end){
		if(start > end || start < 0 || end >= array.length)
			return -1;
		
		int mid = (start+end)/2;
		if(array[mid] == mid)
			return mid;
		else if(array[mid] > mid)
			return getMagicDistinct(array, start, mid -1);
		else
			return getMagicDistinct(array, mid+1, end);
	}
	
	//------------------------------------------------------------------------------------
	// Get Magic index if array is sorted and elements can be repetitive
	
	static int getMagicIndex(int[] array, int start, int end){
		if(start > end || start < 0 || end >= array.length)
			return -1;
		
		int midIndex = (start+end)/2;
		int midValue = array[midIndex];
		if(midIndex == midValue)
			return midIndex;
		
		int leftIndex = Math.min(midIndex-1, midValue);
		int left = getMagicIndex(array, start, leftIndex);
		if(left >= 0)
			return left;
		
		int rightIndex = Math.max(midIndex+1, midValue);
		int right = getMagicIndex(array, rightIndex, end);
		
		return right;
					
	}
}
