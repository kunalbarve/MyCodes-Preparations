package Leetcode;

import java.util.BitSet;
import java.util.HashSet;

/*Given a string, determine if a permutation of the string could form a Palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.*/

public class PalindromePernutation {

	static boolean canPermutePalindrome(String s ){
		if(s == null || s.length() < 1)
			return false;
		
		BitSet b = new BitSet();
		for(byte c: s.getBytes()){
			b.flip(c);
		}
		
		return b.cardinality()<2;
	}
	
	static boolean alternative(String s){
		if(s == null || s.length() < 1)
			return false;
		
		HashSet<Character> set = new HashSet<>();
		
		for(char c: s.toCharArray()){
			if(set.contains(c))
				set.remove(c);
			else
				set.add(c);
		}
		
		return (set.size()<=1);
	}
	
	public static void main(String[] args) {
		
		String s = "aabb";
		
		System.out.println("Is possible:"+alternative(s));
	}

}
