package StringManipulation;

import java.util.*;

public class LongestCommonString {
	
	static String longestCommonSubstring(List<String> input){
		if(input.size() == 0)
			return "";
		
		String result = "";
		
		String shortest = input.get(0);
		for(String s : input){
			if(s.length() < shortest.length())
				shortest = s;
		}
		
		String temp = "";
		for(char c : shortest.toCharArray()){
			temp = temp + c;
			
			boolean isPresent = true;
			
			for(String str : input){
				if(!str.contains(temp)){
					isPresent = false;
					temp = "";
					break;
				}
			}
			
			if(isPresent && temp.length() > result.length())
				result = temp;
			
			if(!isPresent)
				temp = String.valueOf(c);
		}
		
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> input = new ArrayList<>();
		
		System.out.println("Enter Number of strings you want to accept");
		int numberOfInputs = sc.nextInt();
		
		for(int i = 0; i< numberOfInputs; i++){
			input.add(sc.next());
		}
		sc.close();
		
		System.out.println("Input Array: "+input.toString());
		System.out.println("Longest Common string: "+longestCommonSubstring(input));
	}

}
