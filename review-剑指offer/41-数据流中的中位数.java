import java.util.*;

class Solution_offer_41 {
    // 数据流中的中位数
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int n=0;

    public void insert(int val) {
        if(n % 2 == 0) {
            maxHeap.add(val);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(val);
            maxHeap.add(minHeap.poll());
        }
        n++;
    }

    public int getMediean() {
        if(n%2 == 1) return minHeap.peek();
        else return (minHeap.peek() + maxHeap.peek()) /2;
    }

    // 数据流中第一个不重复的字符
    private Queue<Character> queue = new LinkedList<>();
    private int[] cnt = new int[256];
    public void insert(char val) {
        cnt[val] ++;
        queue.offer(val);
        while(!queue.isEmpty() && cnt[queue.peek()] > 1) queue.poll();
    }
    public char poll() {return queue.peek();}
}