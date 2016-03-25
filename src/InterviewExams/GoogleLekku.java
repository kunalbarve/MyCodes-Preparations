package InterviewExams;

public class GoogleLekku {
	
	static int solution(int X){
		int max = 0;
		String test = String.valueOf(X);
		for(int i = 0; i< test.length()-1; i++){
			if(test.charAt(i) == test.charAt(i+1)){
				int no = getValue(test, i);
				if(no > max){
					max = no;
				}
			}
		}
		
		return max;
	}
	
	static int getValue(String s, int index){
		String temp = s.substring(0, index)+s.substring(index+1);
		return Integer.parseInt(temp);
	}

	public static void main(String[] args) {
		int test = 56633;
		System.out.println(solution(test));

	}

}
