import java.util.*;
class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0 ;
        for(int i : nums){
            s+= i ;
        }
        if(s%2!=0) return false;
        int [][] dp = new int[nums.length][s/2+1];
        for(int i = 0 ; i < nums.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return check(nums, 0 , s/2,dp);
    }
    public boolean check(int arr[], int i , int sum,int [][]dp){
        if(sum== 0) return true;
        if(i==arr.length) return false;
        if(dp[i][sum]!=-1){
           return dp[i][sum] =1 ;
        }
        boolean t = false;
        if(arr[i]<=sum){
            t = check(arr,i+1,sum-arr[i],dp);
        }
        boolean n = check(arr,i+1,dp);
        boolean ans = t || n ; 
        dp[i][sum]=ans?1:0;
        return ans;
    }
}