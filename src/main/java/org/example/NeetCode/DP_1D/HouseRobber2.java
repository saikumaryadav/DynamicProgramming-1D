package org.example.NeetCode.DP_1D;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums){
        if(nums.length==1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(houseRobber(Arrays.copyOfRange(nums, 0, nums.length-1)),houseRobber(Arrays.copyOfRange(nums, 1, nums.length)));

    }

    public static int houseRobber(int[] nums){

        // if(nums.length == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

        int[] dp = new int[nums.length+2];
        for(int i=nums.length-1;i>=0;i--){
            dp[i] = Math.max((nums[i]+dp[i+2]),dp[i+1]);
        }
        return dp[0];
    }

}
