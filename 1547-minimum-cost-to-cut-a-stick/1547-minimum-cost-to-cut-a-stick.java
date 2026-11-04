class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int arr[] = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n ; 
        for(int i = 0 ; i < m ; i++){
            arr[i+1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, m + 1, arr, dp);
    }
    public static int solve(int i , int j , int []arr , int[][]dp){
        if (j - i <= 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1 ; k < j ; k++){
            int cost = arr[j] - arr[i]+ solve(i, k, arr, dp)+ solve(k, j, arr, dp);
            ans = Math.min(ans, cost);
        }
        return dp[i][j] = ans;
    }
}