class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for( int i = 0 ; i <s.length();i++ ){
            for(int j = 0 ; j < t.length();j++){
                dp[i][j]=-1;
            }
        }
        return sol( 0, 0 , s , t , dp);
    }
    public int sol(int i , int j , String s , String t , int [][]dp ){
        if (j == t.length()) return 1;
        if (i == s.length()) return 0 ;
        if (dp[i][j] != -1) return dp[i][j];
        int ans  = 0 ;
        ans  = sol(i+1,j,s,t,dp);
        if(s.charAt(i)==t.charAt(j)) ans+=sol(i+1,j+1,s,t,dp);
        return dp[i][j]=ans;
    }
}