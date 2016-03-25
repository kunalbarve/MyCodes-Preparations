package InterviewExams;

public class TwitterBrijesh {

	public static void main(String[] args) {
		String s = "aaaa";
		String sample = "a";
		
		minS(s, sample);
		System.out.println("Count"+count);
	}

	static int count = 0; 
	
	private static void minS(String s, String ss ){
		
		{
			if(s.indexOf(ss)>=0){
				String s1=s.substring(0,s.indexOf(ss));
				String s2=s.substring(s.indexOf(ss)+ss.length(),s.length());
				count++;
				minS(s1+s2,ss);
			} 
		}
	}
	
}
