//GCD
package InterviewExams;

public class ReduceTheFraction {
	
	static String[] getFraction(String[] fractions){
		
		int noOfItems = Integer.parseInt(fractions[0]);
		String[] result = new String[noOfItems];
		
		for(int i = 1; i<=noOfItems; i++){
			String temp = fractions[i];
			int[] arr = getNumbers(temp);
			int gcd = gcd(arr[0], arr[1]);
			String tempResult = (arr[0]/gcd)+"/"+(arr[1]/gcd);
			result[i-1] = tempResult;
		}
		
		return result;
	}
	
	static int[] getNumbers(String fractions){
		int[] arr = new int[2];
		String[] sArr = fractions.split("/");
		arr[0] = Integer.parseInt(sArr[0]);
		arr[1] = Integer.parseInt(sArr[1]);
		return arr;
	} 
	
	static int gcd(int a, int b){
	  while(a!=0 && b!=0) 
	  {
	     int c = b;
	     b = a%b;
	     a = c;
	  }
	  return a>b?a:b; 
	}
	
	public static void main(String[] args) {
//		String[] arr = {"1", "825/1161", "1092/1041", "315/840", "1104/1119", "724/404"};
		String[] arr = {"1", "8/12"};
		String[] result = getFraction(arr);
		for(String fractions: result){
			System.out.println(fractions);
		}

	}

}
