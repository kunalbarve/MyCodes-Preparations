package StringManipulation;

import java.util.*;

public class LongestPlaindrome {
	
//	static String longestPlaindrome(String s){
//		if(s == null)
//			return "";
//		
//		if(s.length() == 0 || s.length() == 1)
//			return s;
//		
//		String longestPlaindrome = s.substring(0, 1);
//		
//		for(int i = 0; i < s.length(); i++){
//			String temp = getPlaindromeFromCenter(s, i, i);
//			if(temp.length() > longestPlaindrome.length())
//				longestPlaindrome = temp;
//			
//			temp = getPlaindromeFromCenter(s, i, i+1);
//			if(temp.length() > longestPlaindrome.length())
//				longestPlaindrome = temp;
//		}
//		
//		return longestPlaindrome;
//		
//	}
//	
//	static String getPlaindromeFromCenter(String s, int start, int end){
//		while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
//			start--;
//			end++;
//		}
//		return s.substring(start+1, end);
//	}
//	
//	public static void main(String []args){
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter String to get Longest Plaindrome\n");
//		
//		String s = sc.nextLine();
//		
//		sc.close();
//		
//		System.out.println("Longest Plaindrome: "+longestPlaindrome(s));
//	}
	
	
	
	/////////////////////////////////////////
	
	
	/*
	 * Complete the function below.
	 */

	static List<String> list = new ArrayList<>();
	static void getPalindromes(String s){
	    
	        for(int i = 0; i < s.length(); i++){
				String temp = getPlaindromeFromCenter(s, i, i);
				if(temp.length() > 1){
					list.add(temp);
	            }
	            
	            temp = getPlaindromeFromCenter(s, i, i+1);
	            if(temp.length() > 1){
	            	list.add(temp);
	            };
			}
			
		}
	
		static String getPlaindromeFromCenter(String s, int start, int end){
			while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)){
				if(start+1 < end){
					String sub = s.substring(start+1, end);
					if(sub.length() > 2){
						list.add(sub);
					}
				}
				start--;
				end++;
			}
			return s.substring(start+1, end);
		}
		
		

	static int count_palindromes(String S) {
	    if(S == null)
				return 0;
	                
	    if(S.length() == 0)
	        return 0;
	    
	    if(S.length() == 1)
	        return 1;
	    
	    getPalindromes(S);
	    return list.size()+S.length();
	}


	public static void main(String []args){
		String S = "wowpurerocks";
		System.out.println("Longest Plaindrome: "+count_palindromes(S));
	}
	
	

}
