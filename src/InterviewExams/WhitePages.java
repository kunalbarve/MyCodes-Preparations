package InterviewExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ArrayHopper Problem 
public class WhitePages {
	
	static List<Integer> getResult(List<Integer> arr){
		try{
			List<Integer> result = new ArrayList<>();
			int current =0, last = 0, selected = 0;
			int i;
			for(i = 0; i< arr.size(); i++){
				if(i> current) break;
				
				if(i > last){
					last = current;
					result.add(selected);
					//System.out.println("Added:"+selected);
				}
				
				int sum = i+arr.get(i);
				
				if(sum > current) selected = i;
				
				current = Math.max(current, sum);
				
				//System.out.println("i: "+i+" sum: "+sum+" ele: "+arr[i]+" current: "+current+" selected: "+selected+" last: "+last);
				
			}
			
			if((i > last) && result.size() > 0 && (result.get(result.size()-1)!= selected))
				result.add(selected);
			
			if(last >= (arr.size()-1))
				return result;
			
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String s = sc.nextLine();
//		sc.close();
		List<Integer> arr = new ArrayList<>();
		String t;
		try{
			while((t = sc.nextLine()) != null){
				arr.add(Integer.parseInt(t));
			}
		}catch(Exception e){
			sc.close();
		}
		
		
//		int[] arr = new int[s.length()];
//		char[] temp = s.toCharArray();
//		int i = 0;
//		for(char c: temp){
//			arr[i] = Character.getNumericValue(c);
//			i++;
//		}
		
		List<Integer> result = getResult(arr);
		String resustStr = "";
		if(result != null && result.size() > 0){
			for(int j : result){
				if(resustStr.isEmpty())
					resustStr = resustStr+j;
				else
					resustStr = resustStr+", "+j;
			}
			resustStr = resustStr+", out";
		}else{
			resustStr = "failure";
		}
		
		System.out.println(resustStr);
	}

}
