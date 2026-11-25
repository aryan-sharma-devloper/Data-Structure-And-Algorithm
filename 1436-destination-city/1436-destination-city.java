class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> rel : paths) {
            map.put(rel.get(0), 1);
        }
        for (List<String> rel : paths) {
            if (!map.containsKey(rel.get(1))) {
                return rel.get(1);
            }
        }
        return "";
    }
}