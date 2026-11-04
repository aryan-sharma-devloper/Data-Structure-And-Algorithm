class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for(int gap = 2 ; gap < m+2 ; gap++){
            for(int i = 0 ; i+gap < m+2; i++){
                int j = i + gap;
                int min = Integer.MAX_VALUE;
                for(int k = i+1; k < j ; k++){
                    int cost = dp[i][k] + dp[k][j] + arr[j] - arr[i];
                    min = Math.min( min , cost);
                }
                dp[i][j] = min ;
            }
        }
        return dp[0][m+1];
    }
}