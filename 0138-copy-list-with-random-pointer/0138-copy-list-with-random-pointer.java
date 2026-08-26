/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head ;
        HashMap<Node , Node> s = new HashMap<>();
        Node curr = head ;
        // so bache there we created all copy nodes 
        while(curr!=null){
            s.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        /// there hum connect krte hai random or next ko 
        while(curr!=null){
            Node copy = s.get(curr);
            copy.next = s.get(curr.next);
            copy.random = s.get(curr.random);
            curr = curr.next;
        }
        return s.get(head);
    }
}