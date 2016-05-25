package InterviewExams;

import java.util.TreeMap;

public class VeizonHarshit {
	
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	
	static int maxCount = 0;
	
	static void customSort(int[] arr) {
		for(int i = 0; i< arr.length; i++){
			int number = arr[i];
			if(map.containsKey(number)){
				int count = map.get(number);
				count++;
				map.put(number, count);
				if(count > maxCount) maxCount = count;
			}else{
				map.put(number, 1);
			}
		}
		
		for(int j = 1; j <= maxCount; j++){
			for(int number : map.keySet()){
				int value = map.get(number);
				if(j == value){
					for(int k = 0; k<value; k++){
						System.out.println(number);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 2, 4};
		customSort(arr);
	}

}
