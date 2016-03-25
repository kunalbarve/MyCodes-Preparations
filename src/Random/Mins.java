package Random;

public class Mins {
	static int count = 0;
	
	public static String minS(String s, String ss  ){
		
		boolean found=false;
		//for(String ss:subs)
		{
			if(s.indexOf(ss)>=0){
				String s1=s.substring(0,s.indexOf(ss));
				String s2=s.substring(s.indexOf(ss)+ss.length(),s.length());
				found=true;
				count++;
				return minS(s1+s2,ss);
			} 
		}
		return s;
		
	}

	public static void main(String[] args){
		 
		System.out.println("RESULT="+minS("ababcab","ab").length() +" count : "+ count ) ;
		count = 0 ;
		System.out.println("RESULT="+minS("abcd","abcd").length()+" count : "+ count );
		count  = 0;
		System.out.println("RESULT="+minS("ccdaabcdbb","cd").length() +" count : "+ count );
		
	}
	
}