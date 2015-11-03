package StringManipulation;
import java.util.*;

public class AnagramChecker {
	
	private boolean isAnagram(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		int[] charCount = new int[256];
		char[] charArray = s1.toCharArray();
		for(char c : charArray){
			charCount[c]++;
		}
		
		for(int i = 0; i<s2.length(); i++){
			int index = s2.charAt(i);
			if(--charCount[index] < 0)
				return false;
		}
		
		return true;
	}
	
	private String getSortedString(String s){
		char[] charArray = s.toCharArray();
		java.util.Arrays.sort(charArray);
		return new String(charArray);
	}
	
	private boolean isAnagramAlt(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		if(getSortedString(s1).equals(getSortedString(s2)))
			return true;
		
		return false;
	}
	
	private boolean allAnagrams(List<String> input){
		if(input.size() == 0)
			return true;
		
		String s1 = input.get(0);
		for(int j = 1; j <input.size(); j++){
			boolean isAnagram = isAnagramAlt(s1, input.get(j));
			if(!isAnagram)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		String s1 = "DOG";
		String s2 = "GOD";
		String s3 = "TRY";
		
		AnagramChecker ac = new AnagramChecker();
		
		System.out.println("Is Anagram:"+ac.isAnagram(s1, s2));
		System.out.println("Is Anagram:"+ac.isAnagramAlt(s1, s3));
		System.out.println("All Are Angrams"+ac.allAnagrams(Arrays.asList(s1, s2)));
		
	}
}
