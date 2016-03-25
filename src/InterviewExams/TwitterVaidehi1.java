package InterviewExams;

import java.util.HashSet;

public class TwitterVaidehi1 {
	
	static HashSet<Integer> beforeSet = new HashSet<Integer>();
	static HashSet<Integer> afterSet = new HashSet<Integer>();

	static String[] BittPattern(int[] num){
		String[] str = new String[2];
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		for(int n : num){
			if(isBeforePresent(n))
				sb1.append("1");
			else
				sb1.append("0");
		}
		
		for(int i = num.length-1; i>=0; i--){
			if(isAfterPresent(num[i]))
				sb2.append("1");
			else
				sb2.append("0");
		}
		
		str[0] = sb1.toString();
		sb2.reverse();
		str[1] = sb2.toString();
		
		
		
		return str;
	}
	
	static boolean isBeforePresent(int n){
		if(beforeSet.contains(n))
			return true;
		
		beforeSet.add(n);
		return false;
	}
	
	static boolean isAfterPresent(int n){
		if(afterSet.contains(n))
			return true;
		
		afterSet.add(n);
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
