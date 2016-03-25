//Return all compound strings which can be broken in to simple strings
package InterviewExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snapchat {

	static String[] simpleWords(String[] words) {

		List<String> list2 = new ArrayList<String>();

		List<String> temp = new ArrayList<>();

		List<String> finalWords = new ArrayList<>();

		for (String w : words) {
			temp.add(w);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				int test = Integer.MIN_VALUE;
				if (words[i].contains(words[j]) && i != j && j > test) {
					words[i] = words[i].replace(words[j], "");
					test = j;
				}
			}

			if (!words[i].isEmpty()) {
				finalWords.add(temp.get(i));
			}
		}

		for (String c : finalWords) {
			if (!c.isEmpty())
				list2.add(c);
		}

		String[] tempArray = new String[list2.size()];
		int i = 0;
		for (String a : list2) {
			tempArray[i] = a;
			i++;
		}

		return tempArray;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();

		String[] input = new String[lines];

		int i = 0;
		while (lines > 0) {
			input[i] = sc.nextLine();
			i++;
			lines--;
		}

		sc.close();

	}

}
