//Post fix evaluation
package InterviewExams;

import java.util.Stack;

public class Cloudera1 {
	
	public static int solution(String s){
		int result = -1;
		if(s.length()>=0 && s.length()<= 200000){
			Stack<Integer> stack = new Stack<>();
			
			char[] array = s.toCharArray();
			
			for(char c : array){
				if(c>= 48 && c<=57){
					stack.push(Character.getNumericValue(c));
				}else if(c == '+' || c=='*'){
					if(!stack.isEmpty()){
						int first = stack.pop();
						if(!stack.isEmpty()){
							int second = stack.pop();
							int temp = 0;
							try{
								if(c == '+')
									temp = Math.addExact(first, second);
								else if(c == '*')
									temp = Math.multiplyExact(first, second);
							}catch(ArithmeticException e){
								return result;
							}
							stack.push(temp);
						}else{
							return result;
						}
					}else{
						return result;
					}
				}
			}
			
			if(!stack.isEmpty())
				result = stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "11++";
		
		System.out.println("Answer:"+solution(s));

	}

}
