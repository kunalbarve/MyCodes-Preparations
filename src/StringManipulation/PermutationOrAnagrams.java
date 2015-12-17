package StringManipulation;

import java.util.*;

//Find all possible permutation or anagrams of the given string. 
	// Time O(n!) as there are n! permutations, we can't do better than this.
public class PermutationOrAnagrams {
	
	static List<String> findAllAnagrams(String s){
		if(s == null)
			return null;
		
		List<String> result = new ArrayList<>();
		if(s.isEmpty())
			result.add("");
		else if(s.length() == 1){
			result.add(s);
		}
		else{
			char firstChar = s.charAt(0);
			List<String> words = findAllAnagrams(s.substring(1));
			for(String word :  words){
				for(int i = 0; i<= word.length() ; i++){
					result.add(word.substring(0, i)+firstChar+word.substring(i));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		System.out.println("All Strings :"+findAllAnagrams(s).toString());
	}
}
