package Arrays;

public class FindSingle {
	
	static int findSingle(int[] n){
		int result = 0;
		int x = 0;
		int sum;
		for(int i = 0; i<32; i++){
			sum = 0;
			x = (1<<i);
			System.out.println("i: "+i+" x: "+x);
			for(int j = 0; j< n.length; j++){
//				if((n[j]&x)){
//					
//					sum++;
//					System.out.println("n: "+n[j]+" x: "+x+" sum: "+sum+" res: "+(n[j]&x));
//				}
			}
			
			if(sum%3 != 0)
				result = result | x;
				
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2, 1,1,3,1,2,2};
		System.out.println("Ans:"+findSingle(arr));

	}

}
