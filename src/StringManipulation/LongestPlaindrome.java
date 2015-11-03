package StringManipulation;

import java.util.*;

public class LongestPlaindrome {
	
	static String longestPlaindrome(String s){
		if(s == null)
			return "";
		
		if(s.length() == 0 || s.length() == 1)
			return s;
		
		String longestPlaindrome = s.substring(0, 1);
		
		for(int i = 0; i < s.length(); i++){
			String temp = getPlaindromeFromCenter(s, i, i);
			if(temp.length() > longestPlaindrome.length())
				longestPlaindrome = temp;
			
			temp = getPlaindromeFromCenter(s, i, i+1);
			if(temp.length() > longestPlaindrome.length())
				longestPlaindrome = temp;
		}
		
		return longestPlaindrome;
		
	}
	
	static String getPlaindromeFromCenter(String s, int start, int end){
		while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start+1, end);
	}
	
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to get Longest Plaindrome\n");
		
		String s = sc.nextLine();
		
		sc.close();
		
		System.out.println("Longest Plaindrome: "+longestPlaindrome(s));
	}

}
