package Random;

import java.util.Scanner;
public class Solution {
    public static Scanner sc;
    
    public static void fillMagicInputs(Character[][] magicInputs, int row, int column){
         for(int i=0; i<row; i++){
             String input = sc.next();
             for(int j = 0; j<column; j++){
                 magicInputs[i][j] = input.charAt(j);
             }
             System.out.print(magicInputs[i][0]);
          }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        sc = new Scanner(System.in);
        int m = sc.nextInt();
		int n = sc.nextInt();
        
        if(m<= 100000 && n<= 500){
            System.out.print("valid input"+m+":"+n);    
            Character[][] magicInputs = new Character[m][n];
            fillMagicInputs(magicInputs, m, n);
            
            
            System.out.println(magicInputs[0].length);
            
        }else{
            System.out.print("Invalid input");    
        }
    }
}