class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        for (List<Integer> edge : edges) {
            in[edge.get(1)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}