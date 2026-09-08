class Solution {
    public int timeRequiredToBuy(int[] t, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i <t.length; i++ ){
            q.offer(i);
        }
        int time = 0 ;
        while(!q.isEmpty()){
            int p = q.poll();
            t[p]--;
            time++;
            if(p == k && t[p]==0) return time ; 
            if(t[p]>0 ) q.offer(p);
        }
        return time ; 
    }
}