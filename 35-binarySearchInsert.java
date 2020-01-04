class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }
    
    public int search(int[] nums, int l, int r, int target) {
        if(l > r) return r+1;
        int mid = (l+r)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target) return search(nums, l, mid-1, target);
        else return search(nums, mid+1, r, target);
    }
}