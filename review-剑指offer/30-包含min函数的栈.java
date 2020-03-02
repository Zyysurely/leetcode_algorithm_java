import java.util.*;

class Solution_offer_30 {
    Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
        int min = x;
        if(!minStack.isEmpty() && min>minStack.peek()) {
            min = minStack.peek();
        }
        minStack.push(x);
        minStack.push(min);
    }

    public int pop() {
        if(minStack.isEmpty()) return -1;
        minStack.pop();
        return minStack.pop();
    }

    public int min() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek();
    }

}