
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

class Solution_138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node res = copyList(head);
        res = copyRandom(res);
        res = splitRandom(res);
        return res;
    }

    Node copyList(Node head) {
        Node res = head;
        while(head != null) {
            head.next = new Node(head.val, head.next, null);
            head = head.next.next;
        }
        return res;
    }

    Node copyRandom(Node head) {
        Node res = head;
        while(head != null) {
            // 随机指针不为空
            if(head.random != null) {head.next.random = head.random.next;}
            head = head.next.next;
        }
        return res;
    }

    Node splitRandom(Node head) {
        Node res = new Node(0, null, null);
        Node r = res;
        while(head != null) {
            res.next = head.next;
            res = res.next;
            head.next = head.next.next;
            head = head.next;
        }
        return r.next;
    }
}