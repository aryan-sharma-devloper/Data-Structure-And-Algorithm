class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][] dp = new int [n+1][n+1];
        for(int i = 1 ; i <=  n;i++){
            dp[i][i]=1;
        }
        for(int len = 2 ; len<=n;len++){
            for(int i = 1 ; i <=n-len+1;i++){
                int j = i+len-1;
                if(s.charAt(i-1)==s.charAt(j-1)){
                dp[i][j] = 2+ dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[1][n];
    }
}