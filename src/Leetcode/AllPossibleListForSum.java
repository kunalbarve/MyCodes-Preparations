package Leetcode;

import java.util.Stack;

public class AllPossibleListForSum {


    /** Set a value for target sum */
    public static final int TARGET_SUM = 15;

    private static Stack<Integer> stack = new Stack<Integer>();

    /** Store the sum of current elements stored in stack */
    private static int sumInStack = 0;

    static void populateSubset(int[] data, int fromIndex, int endIndex) {

        /*
        * Check if sum of elements stored in Stack is equal to the expected
        * target sum.
        * 
        * If so, call print method to print the candidate satisfied result.
        */
        if (sumInStack == TARGET_SUM) {
            print(stack);
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                /*
                * Make the currentIndex +1, and then use recursion to proceed
                * further.
                */
                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }

    /**
    * Print satisfied result. i.e. 15 = 4+6+5
    */

    static void print(Stack<Integer> stack) {
//    	System.out.println(stack.toArray());
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }

	
	
	public static void main(String[] args) {
		 final int[] DATA = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13,
			        14, 15 };

			   
			        populateSubset(DATA, 0, DATA.length);

	}

}
