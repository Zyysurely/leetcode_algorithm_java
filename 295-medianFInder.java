import java.util.*;

class MedianFinder_295 {
    // api的写法
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder_295() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> {return b-a;});
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        if(min.size() > max.size()) {
            max.add(min.remove());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()) return (max.peek() + min.peek())/2.0;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */