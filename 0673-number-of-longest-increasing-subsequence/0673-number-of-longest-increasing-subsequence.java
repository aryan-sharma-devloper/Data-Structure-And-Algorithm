class Solution {
    public int findNumberOfLIS(int[]arr) {
        int n = arr.length;
        int [] len = new int[n];
        int [] count = new int [n];
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        int maxlen = 1 ;
        int ans = 0 ;
        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j]<arr[i]){
                    if(len[j]+1 > len[i]){
                        len[i] = len[j]+1;
                        count[i]=count[j];
                    }
                    else if(len[j]+1==len[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxlen =  Math.max(maxlen,len[i]);
        }
        for(int i = 0 ; i < n;i++){
            if(len[i]==maxlen){
                ans+=count[i];
            }
        }
        return ans;
    }
}