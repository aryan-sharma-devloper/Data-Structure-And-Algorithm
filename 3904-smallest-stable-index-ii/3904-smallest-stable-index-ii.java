class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int pre [] = new int[n];
        pre[n-1] = nums[n-1];
        for(int i = n -2 ;i>=0;i--){
            pre[i] = Math.min(pre[i+1],nums[i]);
        }
        int l =0;
        for(int i = 0 ; i < n;i++ ){
            l = Math.max(l,nums[i]);
            int s = l - pre[i];
            if(s <=k) return i ;
        }
        return -1;
    }
}