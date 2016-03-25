package Leetcode;

 

 
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            digits[i]=digits[i]+carry;
            if(digits[i]<=9)
              return digits;
            digits[i]=digits[i]%10;
            carry=1;
        }
        int[] result= new int[digits.length+1];
        result[0]=1;
        for(int i=0 ;i <digits.length;i++){
            result[i+1]=digits[i];
        }
        return result;
    }
}