class Solution_offer_33 {
    public boolean isBST(int[] nums) {
        if(nums.length <= 1) return true;
        return verify(nums, 0, nums.length-1);
    }

    private boolean verify(int[] nums, int l, int r) {
        if(r-l <= 1) return true;
        int mid = nums[r], index = l;
        while(index < r) {
            if(nums[index] > mid) break;
            index ++;
        }
        int sp = index-1;
        while(index < r) {
            if(nums[index] < mid) return false;
            index++;
        }
        return verify(nums, l, sp) && verify(nums, sp+1, r-1);

    }
}