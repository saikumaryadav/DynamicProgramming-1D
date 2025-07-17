package org.example.NeetCode.DP_1D;

public class ClimbStairs {
    public static void main(String[] args) {

        int n= 5;
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
      /*  if(n==1){
            return n;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            if(i==0 ||i==1){
                res[i] = i+1;
            }
            else{
                res[i] = res[i-1]+res[i-2];
            }
        }
     return res[n-1]; */

        // USING BOTTOM UP Approach
        int one = 1, two =1;  //here one is last but one index, two is last index
        for(int i=n-2;i>=0;i--){
            int temp = one;
            one = one+two;
            two = temp;
        }
        return one;
    }
}
