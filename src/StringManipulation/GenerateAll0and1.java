package StringManipulation;

import java.util.LinkedList;

public class GenerateAll0and1 {
	
	static LinkedList<String> generate(String pattern) {
		LinkedList<String> strings = new LinkedList<String>();
		int pos = pattern.indexOf("?");
		if(pos < 0) {
			strings.add(pattern);
		} else {
			String zeroPattern = pattern.substring(0, pos) + "0" + pattern.substring(pos+1);
			String onePattern = pattern.substring(0, pos) + "1" + pattern.substring(pos+1);
			strings.addAll(generate(zeroPattern));
			strings.addAll(generate(onePattern));
		}
		return strings;
	}
	
	public static void main(String[] args) {
		String s = "1?00?101";
		System.out.println("Answers:"+generate(s).toString());

	}

}
