import java.util.*;


class Solution_581 {
    // 单调栈的方法，但是效率特别差
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int l=len-1, r=0;
        // 找左边界
        for(int i=0; i<len; i++) {
            while(stack.size()>0 && nums[i] < nums[stack.peek()])  l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        // 找右边界
        for(int i=len-1; i>=0; i--) {
            while(stack.size()>0 && nums[i] > nums[stack.peek()])  r = Math.max(r, stack.pop());
            stack.push(i);
        }
        if(r == 0) return 0;
        return r-l+1;
    }
    // 最大最小值的方法
    public int findUnsortedSubarray_2(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) return 0;
        int maxValue=0, minValue=0;
        int l=-1, r=-1;
        // 这个其实是在找右边界，假设左边都有序，那么右边一定比左边的都大
        for(int i=0; i<len; i++) {
            if(i==0) maxValue = nums[i];
            else {
                if(nums[i] < maxValue) l=i;
                maxValue = Math.max(maxValue, nums[i]);
            }
        }
        // 这个是在找左边界，右边都倒序有序
        for(int i=len-1; i>=0; i--) {
            if(i==len-1) minValue = nums[i];
            else {
                if(nums[i] > minValue) r=i;
                minValue = Math.min(minValue, nums[i]);
            }
        }
        if(l==-1) return 0;
        return l-r+1;
    }
}