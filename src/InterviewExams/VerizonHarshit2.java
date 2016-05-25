package InterviewExams;

public class VerizonHarshit2 {
	
	
	static int lastSum = 0;
	
	static void calculate(int[] arr) {
		for(int i = 0; i< arr.length; i++){
			int number = arr[i];
			if(number %2 != 0){
				lastSum += number;
			}
			System.out.println(lastSum);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		calculate(arr);
	}
}
