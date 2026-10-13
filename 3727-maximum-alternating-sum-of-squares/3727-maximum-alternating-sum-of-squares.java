class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0 ; i < nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        int n = nums.length;
        long ans =0 ;
        int m = n/2;
        for(int i= 0 ; i < m ; i++){
           ans-=nums[i];
        }
        for(int i = m ; i < n ; i++ ){
            ans+=nums[i];
        }
        return ans;
    }
}