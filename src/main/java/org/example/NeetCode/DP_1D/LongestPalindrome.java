package org.example.NeetCode.DP_1D;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {

        String res = "";
        int count = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){

                if(right-left+1>count){
                    res = s.substring(left, right+1);
                    count = res.length();
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){

                if(right-left+1>count){
                    res = s.substring(left, right+1);
                    count = res.length();
                }
                left--;
                right++;
            }
        }

        return res;
    }
}
