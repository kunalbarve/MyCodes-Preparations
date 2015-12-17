package InterviewExams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class Test {
	
	public static HashMap<Character, Integer> getOrder(String cipher){
		char[] array = cipher.toCharArray();
		java.util.Arrays.sort(array);
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0;
		
		for(char c : array){
			map.put(c, i);
			i++;
		}
		return map;
	}
	
	public static char[][] getArray(String cipher, String input){
		int cLength = cipher.length();
		int inputLength = input.length();
		int remainder = inputLength%cLength;
		
		int rows = 0;
		if(remainder == 0)
			rows = (inputLength/cLength);
		else
			rows = (inputLength/cLength)+1;
		
		char[][] result = new char[rows][cLength];
		
		int k = 0;
		int l = 97;
		for(int i = 0; i< rows;i++){
			for(int j = 0; j<cLength; j++){
				if(k != inputLength){
					result[i][j] = input.charAt(k);
					k++;
				}else{
					result[i][j] = (char)l;
					l++;
				}
			}
		}
		
		return  result;
	}
	
	public static String makeString(char[][] input, HashMap<Character, Integer> map, String cipher){
		StringBuffer sb = new StringBuffer();
		
		for(char c : map.keySet()){
			int index = cipher.indexOf(c);
			for(int i = 0; i< input.length; i++){
				sb.append(input[i][index]);
			}
		}
		return sb.toString().toUpperCase();
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cipher = sc.nextLine();
		int no = Integer.parseInt(sc.nextLine());
		List<String> inputs = new ArrayList<>();
		
		while(no > 0){
			inputs.add(sc.nextLine());
			no--;
		}
		
		sc.close();
		
		HashMap<Character, Integer> map = getOrder(cipher);
		
		for(int i = 0; i< inputs.size();i++){
			char[][] result = getArray(cipher, inputs.get(0));
			System.out.println(makeString(result, map, cipher));
		}
		
	}
}