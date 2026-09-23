class Solution {
    public int reverseDegree(String s) {
        int v = 0;
        for(int i = 1 ; i <= s.length();i++){
            v += ('z'-s.charAt(i-1)+1)*i;
        }
        return v;
    }
}