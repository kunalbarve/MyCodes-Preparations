package InterviewExams;

import java.util.HashMap;

public class Test2{
	public static void main(String[] args){
		
		HashMap<String, String> hash = new HashMap<>();
		
		String s1 = "try1";
		String s2 = "try2";
		
		hash.put(s1, "try1");
		hash.put(s2, "try2");
		
		System.out.println(hash);
		
		s1 = "something";
		System.out.println("Str:"+hash.get(s1));
		
		System.out.println(hash);
		
	}
}
