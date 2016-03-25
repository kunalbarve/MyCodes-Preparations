//Directory Question
package InterviewExams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class GoogleLekku2 {
//	
//	
//	
//	static int solution(String s){
//		List<String> array = new ArrayList<>();
//		String[] array1 = s.split("\n");
//		array.addAll(Arrays.asList(array1));
//		int currlevel = 0;
//		int sum = 0;
//		int parentLength = 0;
//		
//		for(String temp : array){
//			String newStr = temp.trim();
//			if(temp.length() - newStr.length() != currlevel ){
//				
//			}else{
//				currlevel = 0;
//				
//			}
//			if(!(temp.length() == newStr.length())){
//				int space = temp.length() - newStr.length();
//				if(checkImageFile(newStr)){
//					
//				}
//			}
//		}
//		
//		
//		return 0;	
//	}
//	
//	static boolean checkImageFile(String s){
//		if(s.contains(".png") || s.contains(".gif") || s.contains(".jpeg"))
//			return true;
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		
//	}
//
//}

public class GoogleLekku2 {
	public int solution(String S) {
		// dirNames is an array of string with elements as values from S split
		// by end of line character
		String[] dirNames = S.split("\n");
		int absPathLength = 0;
		for (int i = dirNames.length - 1; i >= 0; i--) {
			// Check if there are images in any directory
			if (checkImage(dirNames[i])) {
				int spaceCount = numSpaces(dirNames[i]);
				// Check if there are images in the root directory
				if (spaceCount == 0) {
					// the value of the length of directory path is stored in
					// absPathLength
					absPathLength += dirNames[i].length() + 1;
				} else {
					int spaceNum = spaceCount - 1;
					while (spaceNum >= 0) {
						// The parent directory is retrieved in case we don't
						// find an image in current directory and traverse to
						// subdirectory
						absPathLength += getParentDir(dirNames, i, spaceNum) + 1;
						spaceNum--;
					}
				}
			}
		}
		return absPathLength;
	}

	private int getParentDir(String[] dirNames, int index, int dirSpaces) {
		for (int i = index - 1; i >= 0; i--) {
			int spaceCount = numSpaces(dirNames[i]);
			// Check for the parent directory match
			if (spaceCount == dirSpaces)
				return dirNames[i].length() - spaceCount;
		}
		return 1;
	}

	// The Image Extensions are stored in string array imgExt
	private final String[] imgExt = { ".jpeg", ".png", ".gif" };

	// Check whether the file name passed as parameter has an image extension
	private boolean checkImage(String fileName) {
		for (String fileExt : imgExt) {
			if (fileName.endsWith(fileExt))
				return true;
		}
		return false;
	}

	// The total number of spaces is returned by this function
	private int numSpaces(String fileName) {
		int num = 0;
		int curIndex = 0;
		while (curIndex < fileName.length()) {
			if (fileName.charAt(curIndex) == ' ')
				num++;
			else
				break;
			curIndex++;
		}
		return num;
	}

	public static void main(String args[]) {
		GoogleLekku2 sol = new GoogleLekku2();
		String fileName = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\n dir2\n file2.gif";
		System.out.println(sol.solution(fileName));
	}
}
