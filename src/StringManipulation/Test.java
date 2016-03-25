package StringManipulation;

public class Test {
	
	static String solve(String s){
		char[] c = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = c.length-1; i>= 0; i--){
			if(c[i+1] == ' ' || i==c.length-1)
				sb.append(Character.toUpperCase(c[i]));
			else
				sb.append(c[i]);
		} 
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solve("Hello Kunal"));

	}

}
