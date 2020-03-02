import java.util.*;

class Solution_offer_59 {
    // 双端队列求解
    public int[] maxInWindow(int[] nums, int k) {
        LinkedList<Integer> max = new LinkedList<>();
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int i=0, index=0;
        while(i < nums.length) {
            while(!max.isEmpty() && i-max.peek() >= k) max.poll();
            // 不可能成为后面窗口最大值的删除
            while(!max.isEmpty() && nums[i] > nums[max.peekLast()]) max.pollLast();
            max.add(i);
            i++;
            if(i >= k) {
                res[index] = nums[max.peek()];
                index++;
            }
        }
        return res;
    }

    // 从后往前建立堆
    private void buildHeap(int[] nums) {
        for(int i=nums.length/2-1; i>=0; i--) {
            heapify(nums, i);
        }
    }

    // 调整堆
    private void heapify(int[] nums, int i) {
        int l=2*i+1;
        int r=2*i+2;
        int max = i;
        int len = nums.length;
        if(l<len && nums[max] < nums[l]) {
            max = l;
        }
        if(r<len && nums[max] < nums[r]) {
            max = r;
        }
        if(max != i) {
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
            heapify(nums, max);
        }
    }
}