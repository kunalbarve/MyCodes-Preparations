package InterviewExams;

import java.util.Stack;

public class Google {

	public int largestArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();

		int max = 0;
		int i = 0;

		while (i < height.length) {
			System.out.println("I"+i);
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				System.out.println("H*W"+h+":"+w);
				max = Math.max(h * w, max);
			}
			System.out.println("Max:"+max);
			System.out.println("Stack"+stack.toString());
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] input = { 5, 3, 4, 2 };
		Google g = new Google();
		System.out.println(g.largestArea(input));
	}
}
