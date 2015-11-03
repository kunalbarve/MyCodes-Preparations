package StringManipulation;

public class Compression {
	
	static String compressedString(String s){
		if(s == null || s.isEmpty())
			return "";
		
		int count =1;
		char lastChar = s.charAt(0);
		StringBuffer result = new StringBuffer();
		
		for(int i = 1; i < s.length(); i++){
			char c = s.charAt(i);
			if(lastChar == c)
				count++;
			else{
				result.append(lastChar);
				result.append(count);
				lastChar = c;
				count = 1; 
			}
		}
		
		result.append(lastChar);
		result.append(count);
		
		String resultString = result.toString();
		
		if(resultString.length() > s.length())
			return s;
		
		return resultString;
	}
	
	static String doCompressionUsingArray(String s){
		int newSize = getNewSize(s);
		if(newSize > s.length()) return s;
		
		char[] charArray = new char[newSize];
		int count = 1, index = 0;
		char last = s.charAt(0);
		
		for(int i =1; i< s.length(); i++){
			if(s.charAt(i) == last) count++;
			else{
				charArray[index] = last;
				index++;
				for(char c: String.valueOf(count).toCharArray()){
					charArray[index] = c;
					index++;
				}
				last = s.charAt(i);
				count = 1;
			}
		}
		charArray[index] = last;
		index++;
		for(char c: String.valueOf(count).toCharArray()){
			charArray[index] = c;
			index++;
		}
		return String.valueOf(charArray);
	}
	
	static int getNewSize(String str){
		if(str.isEmpty()) return 0;
		char last = str.charAt(0);
		int count = 1, size = 0;
		for(int i=1; i< str.length(); i++){
			if(str.charAt(i) == last) count++;
			else{
				size += 1 + String.valueOf(count).length();
				count = 1;
				last = str.charAt(i);
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static void main(String[] args){
		String s1 = "aaaaaaaaaaabbbbbbccccdddddddddeeeeeeeefgughghjffddddddd";
		System.out.println("Original  : "+s1);
		System.out.println("Compressed: "+compressedString(s1));
	}
}
