class Solution_offer_63 {
    public int maxProfit(int[] nums) {
        if(nums.length == 0) return 0;
        int out = nums[0];
        int max = 0;
        for(int i=1; i<nums.length; i++) {
            out = Math.min(out, nums[i]);
            max = Math.max(max, nums[i] - out);
        }
        return max;
    }
}