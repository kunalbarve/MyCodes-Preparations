package StringManipulation;
import java.util.*;

public class UniqueCharacters {
	
	static boolean allCharactersUnique(String s){
		if(s.length() > 256)
			return false;
		
		boolean[] charArray = new boolean[256];
		for(char c : s.toCharArray()){
			if(charArray[c])
				return false;
			else
				charArray[c] = true;
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		System.out.println("All Unique? :"+allCharactersUnique(s));
	}
}
