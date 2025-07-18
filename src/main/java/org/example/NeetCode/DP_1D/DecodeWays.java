package org.example.NeetCode.DP_1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "122016";
        System.out.println(numDecodings("",s));
        System.out.println(decodes(s));
        System.out.println(numDecodings(s));
    }

    public static List<String> numDecodings(String up, String s) {
        List<String> list  = new ArrayList<>();
        if(s.isEmpty() ){
            list.add(up);
            return list;
        }
        List<String> left;
        List<String> right;

        if(Integer.valueOf(s.charAt(0)+"") == 0 ){
            return new ArrayList<>();
        }
            left = numDecodings(up + s.charAt(0) + "->", s.substring(1));
//&&  Integer.valueOf(s.charAt(0)+s.charAt(1))<=26
            if (s.length() > 1 && Integer.valueOf(s.charAt(0) + "" + s.charAt(1)) <= 26) {
                // System.out.println(s.charAt(0)+""+s.charAt(1));
                right = numDecodings(up + s.charAt(0) + s.charAt(1) + "->", s.substring(2));
                left.addAll(right);
            }

        return left;
    }

    public static int decodes(String s){
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) != '0'){
            dp[1] = 1;
        }
        //try for dp index as well because i dont confuse... just we can adjust the string char index
        for(int i=1;i<s.length();i++){
            System.out.println(s.charAt(i) !='0');
            if(s.charAt(i) !='0' ){
                dp[i+1] += dp[i];
            }
            System.out.println(Integer.valueOf(s.charAt(i-1)+""+s.charAt(i)) >0 && Integer.valueOf(s.charAt(i-1)+""+s.charAt(i)) <=26 );
            if(s.charAt(i-1) !='0' && Integer.valueOf(s.charAt(i-1)+""+s.charAt(i)) >0 && Integer.valueOf(s.charAt(i-1)+""+s.charAt(i)) <=26 ){
                dp[i+1] += dp[i-1];
            }
            System.out.println(Arrays.toString(dp));


        }
        System.out.println(Arrays.toString(dp));

        return dp[s.length()];
    }
    public static int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<=s.length();i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int twoDigits = Integer.valueOf(s.substring(i-2,i));
//            System.out.println(first);
//            System.out.println(twoDigits);
            if(first >=1){
                dp[i] += dp[i-1];
            }
            if(twoDigits >=10 && twoDigits <=26){
                dp[i]+= dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
