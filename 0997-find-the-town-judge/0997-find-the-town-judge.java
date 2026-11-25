class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] in = new int[n+1];
        int [] out = new int [n+1];
        for(int []rel : trust){
            out[rel[0]]++;
            in[rel[1]]++;
        }
        for(int p = 1 ; p <= n;p++){
            if(in[p]==n-1 && out[p]==0) return p;
        }
        return -1;
    }
}