package org.example.NeetCode.DP_1D;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {

        // ALWAYS FOLLOW BOTTOM UP APPROACH AND WRITE RECCURANCE RELATION
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length+2];
        for(int i=nums.length-1;i>=0;i--){
            dp[i] = Math.max((nums[i]+dp[i+2]), dp[i+1]);
        }
        return dp[0];
    }
}
