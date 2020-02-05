class Solution_42 {
    // 通过左边最大值和右边最大值的比较
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] left = new int[height.length];
        left[0] = 0;
        for(int i=1; i<height.length; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        int[] right = new int[height.length];
        right[height.length-1] = 0;
        for(int i=height.length-2; i>=0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }
        int res=0;
        for(int i=0; i<height.length; i++) {
            int min = Math.min(left[i], right[i]);
            res += Math.max(0, min-height[i]);
        }
        return res;
    }
}