package Utility;

public class Util {
	
	// Random number generator without inbuilt method
	static	long randomNumber(long seed) {
		  seed ^= (seed << 21);
		  seed ^= (seed >>> 35); // 3 > symbols!
		  seed ^= (seed << 4);
		  return seed;
	}
	
	public static void printArray(int[] input){
		String result = "";
		for(int i= 0; i< input.length; i++){
			if(result.equals("")){
				result = String.valueOf(input[i]);
			}else{
				result = result +" "+ input[i];
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		System.out.println("Random Number: "+randomNumber(12345));
	}

}
