package Leetcode;

public class StrStr {
    public String strStr(String haystack, String needle) {
        if(needle.length()==0)
           return null;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)== needle.charAt(0)){
                int j=i+1;
                while(j<haystack.length() && (j-i)<needle.length() && haystack.charAt(j)== needle.charAt(j-i))
                   j++;
                if(j-1==needle.length())
                   return i+"";
            }
        }
        return null;
    }
}