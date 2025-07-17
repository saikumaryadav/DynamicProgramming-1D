package org.example.NeetCode.DP_1D;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(arr));
    }
    public static int minCostClimbingStairs(int[] cost) {
        //ALWAYS DO BOTTOM UP APPROACH
        for(int i=cost.length-3;i>=0;i--){
            cost[i] = Math.min((cost[i]+cost[i+1]), (cost[i]+cost[i+2]));
        }
        return Math.min(cost[0],cost[1]);
    }
}
