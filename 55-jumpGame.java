class Solution_55 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length-1;
        // 贪心算法，从后往前看能否到最后一个
        for(int i=nums.length-1; i>=0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}