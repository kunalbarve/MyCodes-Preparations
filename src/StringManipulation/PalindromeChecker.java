package StringManipulation;

public class PalindromeChecker {
	
	private boolean isPlaindrome(String s){
		if(s == null || s.isEmpty())
			return false;
		
		int start = 0, 
			end = s.length()-1, 
			middle = (start+end)/2,
			i = 0;
		
		for(i = start ; i<= middle ; i++){
			if(s.charAt(start) == s.charAt(end)){
				start++;
				end--;
			}else{
				break;
			}
		}
		
		if(i == middle+1)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		PalindromeChecker pc = new PalindromeChecker();
		System.out.println("Is Plaindrom:"+pc.isPlaindrome("ABCDECBA"));

	}

}
