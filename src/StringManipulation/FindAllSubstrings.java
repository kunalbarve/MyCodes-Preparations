package StringManipulation;

import java.util.*;

public class FindAllSubstrings {
	
	static List<String> findAllSubstrings(String s){
		if(s == null)
			return null;
		List<String> result = new ArrayList<>();
		int len = s.length();
		if(len == 0 || len == 1){
			result.add(s);
			return result;
		}
		
		for(int i = 0; i< len; i++){
			for(int j = i+1; j<=len; j++){
				result.add(s.substring(i, j));
			}
		}
		return result;
	}
	
	// Recursive approach
	static List<String> recursiveResult = new ArrayList<>();
	static void generateSubStrings(String input, int start, int end){
		if(start == input.length() && end == input.length()+1){
			return;
		}else{
			if(end == input.length()+1){
				generateSubStrings(input, start+1, start+2);
			}else{
				recursiveResult.add(input.substring(start, end));
				generateSubStrings(input, start, end+1);
			}
			
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String to get all substrings\n");
		
		String s = sc.nextLine();
		
		sc.close();
		
		System.out.println("All Substring Iterative : "+findAllSubstrings(s).toString());
		
		generateSubStrings(s, 0, 1);
		System.out.println("All Substring Recursive : "+recursiveResult.toString());
	}
	
}
