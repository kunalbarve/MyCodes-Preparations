package Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Utility{
	
	// Method to return the reverse of a number
    public int reverse(int num) {
        int revNum = 0;
        while (num > 0) {
            int rem = num % 10;
            revNum = (revNum * 10) + rem;
            num = num / 10;
        }
        return revNum;
    }
	
	public static void main(String[] args){
//		To read the input from command line word by word. Space will not be considered. It will start the next input.
//		import java.util.Scanner;
		Scanner sc = new Scanner(System.in);
		String input = sc.next(); // Reads the next token
		int number = sc.nextInt();
		String inputLine = sc.nextLine(); // Reads the whole line
		System.out.println(input+number+inputLine);
		sc.close();


//		To Read the input from command line line by line
//		import java.io.BufferedReader;
//		import java.io.InputStreamReader;
//		import java.io.IOException;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String inputSr = br.readLine();
			br.close();
			System.out.print(inputSr);
		}catch(IOException e){
			e.printStackTrace();
		}

//		String Tokenizer
//		import java.util.StringTokenizer;
		String str = "";
		StringTokenizer st = new StringTokenizer(str);
//		StringTokenizer stt = new StringTokenizer(str, " ");

		while(st.hasMoreElements()){
			String first = st.nextToken();
			System.out.println(first);
		}
		
//		To Sort a string simple method
		char[] charArray = input.toCharArray();
		java.util.Arrays.sort(charArray);
		String sortedStr = new String(charArray);
		System.out.println(sortedStr);
		
//		import java.util.Stack;
//		Use of stack push, pop, peek, isEmpty
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		System.out.println(stack.pop());
		

//		import java.util.LinkedList;
//		import java.util.Queue;
//		Use of Queue: poll, peek, isEmpty, add
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		System.out.println(queue.poll());

		
	}
}


