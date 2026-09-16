class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> a = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
           if(a.isEmpty() || a.peek() != s.charAt(i)) {
                a.push(s.charAt(i));
            } else {
                a.pop();
            }         
           }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : a) {
            sb.append(ch);
        }
        return sb.toString();
    }
}