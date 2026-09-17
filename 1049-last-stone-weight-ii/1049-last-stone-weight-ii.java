class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int s = 0 ; 
        for(int i : stones){
            s+=i;
        }
        int t = s/2;
        boolean [][]dp = new boolean[n+1][t+1];
        for(int i = 0 ; i <=n;i++){
            dp[i][0]= true;
        }
        for(int i = 1 ; i <=n;i++){
            for(int j =1 ; j <=t;j++){
                dp[i][j] = dp[i-1][j];
                if(j >=stones[i-1]){
                    dp[i][j] = dp[i-1][j-stones[i-1]] || dp[i-1][j];
                }
            }
        }
        for(int j = t ; j >= 0 ; j--){
            if(dp[n][j]){
                return s-2*j;
            }
        }
        return 0 ;
    }
}