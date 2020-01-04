import java.util.*;

class DLinkedNode {
    DLinkedNode prev;
    DLinkedNode next;
    int key;
    int value;
}

class LRUCache_146 {

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }
    private int removeNode(DLinkedNode node) {
        int res = node.key;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return res;
    }
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    
    
    private DLinkedNode head, tail;
    private int cap, count;
    private HashMap<Integer, DLinkedNode> content = new HashMap<Integer, DLinkedNode>();
    public LRUCache_146(int capacity) {
        this.count = 0;
        this.cap = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.prev = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        DLinkedNode node = this.content.get(key);
        if(node == null){
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = this.content.get(key);
        if(node == null) {
            DLinkedNode ad = new DLinkedNode();
            ad.key = key;
            ad.value = value;
            
            this.addNode(ad);
            this.content.put(key, ad);
            count ++;
            
            if(count > this.cap){
                int k = this.removeNode(this.tail.prev);
                this.content.remove(k);
                count --;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */