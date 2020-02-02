class Solution_153 {
    public int findMin(int[] nums) {
        int val = nums[0];
        int com = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                com = nums[i];
                break;
            }
        }
        return Math.min(val, com);
    }
}