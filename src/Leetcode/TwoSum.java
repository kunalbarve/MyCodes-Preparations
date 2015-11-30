package Leetcode;

import java.util.HashMap;

import Utility.Util;

/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

public class TwoSum {
	
	static int[] getIndex(int target, int[] input){
		int[] index = new int[2];
		HashMap<Integer, Integer> result = new HashMap<>();
		for(int i = 0; i< input.length; i++){
			if(result.containsKey(input[i])){
				int itemIndex = result.get(input[i]);
				index[0] = Math.min(i+1, itemIndex+1);
				index[1] = Math.max(i+1, itemIndex+1);
				return index;
			}
			result.put(target- input[i], i);
		}
		return index;
	}

	public static void main(String[] args) {
		int[] input = {2,7, 11, 15};
		
		int[] result = getIndex(9, input);
		Util.printArray(result);

	}

}
