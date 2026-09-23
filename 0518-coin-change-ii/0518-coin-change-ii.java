class Solution {
    public int change(int amount, int[] coins) {
        int [][]dp = new int[coins.length][amount+1];
        for(int []r : dp){
        Arrays.fill(r,-1);
        }
        return solve(amount,coins,dp,0);
    }
    public int solve(int amount , int[]coins, int[][]dp,int i){
        if(amount==0) return 1;
        if(i == coins.length) return 0;
        if(dp[i][amount]!= -1) return dp[i][amount];
        int skip = solve(amount,coins,dp,i+1);
        int pick = 0 ;
        if(amount>=coins[i]){
            pick = solve(amount-coins[i] , coins , dp ,i);
        }
        return dp[i][amount] = pick + skip;
    }
}