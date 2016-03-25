package InterviewExams;

public class TwitterBrijesh2 {

	
	int [] f = new int [100];
	
	int FactorialDP(int n){
	    if(n == 0 || n == 1)
	        return 1;
	    else if(f[n] != 0) // already calculated case
	        return f[n];
	    else 
	        return f[n] = n * FactorialDP(n-1);
	}
	public static void main(String[] args) {
		
		TwitterBrijesh2 f = new TwitterBrijesh2();
		int count = 1;
	
		int input = 2;
		for(int i = 1;i<=input;i++)
		{
			if((f.FactorialDP(i)%i) -(i-1) == 0)
			{
				count++;
			}
		}
	   
		System.out.println(count);
	}
}
