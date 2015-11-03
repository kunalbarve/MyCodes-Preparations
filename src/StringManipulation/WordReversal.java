package StringManipulation;

import java.util.*;

public class WordReversal {
	
	static String reverseWord(String s){
		String result = "";
		String word = "";
		
		for(char c: s.toCharArray()){
			if(c == ' '){
				if(result.isEmpty())
					result = word;
				else
					result = word+" "+result;
				word = "";
			}else{
				word = word + c;
			}
		}
		result = word+" "+result;
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to reverse\n");
		
		String s = sc.nextLine();
		
		sc.close();
		
		System.out.println("Reverse String:"+reverseWord(s));

	}

}
