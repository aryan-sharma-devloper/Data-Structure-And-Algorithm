import java.util.* ;
class Solution {
    public boolean isValid(String s) {
        Stack<Character>sh = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
            char ch = s.charAt(i);
            if(ch=='{' || ch=='(' || ch=='['){
                sh.push(ch);
            }else {
                if(sh.isEmpty()) return false ;
                
                if(ch == '}' && sh.pop()!='{') return false ;
                if(ch == ']' && sh.pop()!='[') return false ;
                if(ch == ')' && sh.pop()!='(') return false ;
            }
        }
        return sh.isEmpty() ;
    }
}