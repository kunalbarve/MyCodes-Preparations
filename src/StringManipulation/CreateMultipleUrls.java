package StringManipulation;

import java.util.*;

public class CreateMultipleUrls {
	
	static List<String> generateUrls(List<List<String>> input){
		if(input == null)
			return null;
		
		if(input.size() == 1)
			return input.get(0);
		
		List<String> first = input.get(0);
		input.remove(0);
		List<String> second = generateUrls(input);
		List<String> result = new ArrayList<>();
		for(String s1 : first){
			for(String s2: second){
				result.add(s1+"."+s2);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		List<List<String>> input = new ArrayList<>();
		List<String> l1 = Arrays.asList("paypal","amazon","google");
		List<String> l2 = Arrays.asList("frontend","backend");
		List<String> l3 = Arrays.asList("org","com","in");
		
		input.add(l1);
		input.add(l2);
		input.add(l3);
		
		List<String> urls = generateUrls(input);
		
		System.out.println("Output:\n"+urls.toString());
		System.out.println("Size:"+urls.size());
	}

}
