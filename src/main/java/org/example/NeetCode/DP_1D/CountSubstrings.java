package org.example.NeetCode.DP_1D;

public class CountSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        String res = "";
        int count = 0;
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){


                    count =count+1;

                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){

                count = count+1;
                left--;
                right++;
            }
        }

        return count;
    }
}
