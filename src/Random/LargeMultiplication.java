package Random;

import java.util.Arrays;

public class LargeMultiplication {
    public static void main(String[] args) {
        int bigInt1 = Integer.MAX_VALUE,  bigInt2 = 123456;
        System.out.println(bigInt1+" * "+bigInt2+" = "+multiply(bigInt1, bigInt2));
    }    
    public static String multiply(int bigInt1, int bigInt2) {
    	
    	String s1 = Integer.toString(bigInt1);
    	String s2 = Integer.toString(bigInt2);
    	int length = Math.max(s1.length(), s2.length());
    	
    	int[] array1 = getArray(s1, length);
    	int[] array2 = getArray(s2, length);
    	
    	System.out.println(Arrays.toString(array1));
    	System.out.println(Arrays.toString(array2));
    	
        return product(array1, array2);
    }
    
    /** Solution logic here*/
    private static String product(int[] array1, int[] array2) {
        int product[] = new int[array1.length + array2.length]; //[n+m]
        
        for(int i=0; i<array1.length; i++){        
            for(int j=0; j<array2.length; j++){ 
                
                int prod = array1[i] * array2[j];
                String prodStr = String.valueOf(prod);
                int prodLength = prodStr.length();
                int prodAsArray[] =  getArray(prodStr, prodLength);
                
                //If the product has 2 digits, the 2nd one should be stored in the next index
                for (int k =0; k < prodAsArray.length; k++) {//1 to 2 iterations, at most
                    product[i+j+k] += prodAsArray[k];
                    
                    //Handle carry 
                    int currentValue = product[i+j+k];
                    if(currentValue>9){
                        product[i+j+k] = 0; 
                        String currentStr = String.valueOf(currentValue);
                        int curValueLength = currentStr.length();
                        int curValueAsArray[] = getArray(currentStr, curValueLength);
                        for (int l = 0; l < curValueAsArray.length; l++) {
                            product[i+j+k+l] += curValueAsArray[l];
                        }
                    }
                }      
            }
        }
        return arrayToString(product);
    }
    
    private static int[] getArray(String s, int length){
    	int[] result = new int[length];
    	int sLength = s.length();
    	int diff = length - sLength;
    	
    	int j = 0;
    	for(int i = s.length()-1; i>= 0; i--){
    		result[j] = Character.getNumericValue(s.charAt(i));
    		j++;
    	}
    	
    	while(diff > 0 && j<length){
    		result[j++] = 0;
    		diff--;
    	}
    	return result;
    }
    
    private static String arrayToString(int[] sumArray) {
        String sum = "";
        boolean firstNonZero = false; 
        for (int i = sumArray.length-1; i >= 0 ; i--) { //from array end to beginning
            
            if(!firstNonZero && (sumArray[i]==0)){ //ignore if 1st digits are 0 
                continue;
            } else{
                firstNonZero=true;
            }
            sum += sumArray[i];
            if((i%3 ==0)&&i!=0){ sum +=",";}  //formatting
        }
        String sumStr = sum.length()==0?"0":sum; // handle the 0 value (ha, input was not big!)
        return sumStr;
    }
}