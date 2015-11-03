package StringManipulation;

public class RotationalString{
	
	private static boolean checkRotation(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		
		if(s1.length() > 0){
			return isSubString(s1+s1, s2);
		}
		return false;
	}
	
	private static boolean isSubString(String s1, String s2){
		return s1.toLowerCase().contains(s2.toLowerCase());
	}
	
	public static void main(String[] args){
		String s1 = "watterbottle";
		String s2 = "erbottleWATT";
		if(checkRotation(s1, s2)){
			System.out.print("Rotational Strings");
		}else{
			System.out.print("Not a rotational String");
		}
	}
}
