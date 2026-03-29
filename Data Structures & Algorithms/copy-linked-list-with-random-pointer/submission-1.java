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
        HashMap<Node, Node> copy = new HashMap<>();
        copy.put(null, null);
        Node curr = head;

        while (curr != null) {
            if (!copy.containsKey(curr)) {
                copy.put(curr, new Node(0));
            }

            if (!copy.containsKey(curr.next)) {
                copy.put(curr.next, new Node(0));
            }

            if (!copy.containsKey(curr.random)) {
                copy.put(curr.random, new Node(0));
            }

            Node currCopy = copy.get(curr);
            currCopy.val = curr.val;
            currCopy.next = copy.get(curr.next);
            currCopy.random = copy.get(curr.random);

            curr = curr.next;
        }
        return copy.get(head);
    }
}
