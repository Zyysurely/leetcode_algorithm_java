class Solution_11 {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length-1;
        int max = 0;
        while(first < last){
            int cur = Math.min(height[first], height[last])*(last-first);
            if(cur > max){
                max = cur;
            }
            if(height[first] > height[last]) {
                last--;
            } else {
                first++;
            }
        }
        return max;
    }
}
// 正确性证明，这种双指针方法是正确的