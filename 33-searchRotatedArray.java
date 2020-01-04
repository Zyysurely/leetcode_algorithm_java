class Solution_33 {
    // 二分搜索，但是顺序不对
    public int search(int[] nums, int target) {
        return findProSearch(nums, 0, nums.length-1, target);
    }
    
    public int findProSearch(int []nums, int l, int r, int target) {
        if(l > r) return -1;
        int mid = (l+r)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < nums[r]) {  // 右半边有序
            if(nums[mid] < target && nums[r] >= target) return findProSearch(nums, mid+1, r, target);
            else return findProSearch(nums, l, mid-1, target);
        } else {                  // 左半边有序
            if(nums[l] <= target && nums[mid] > target) return findProSearch(nums, l, mid-1, target);
            else return findProSearch(nums, mid+1, r, target);
        }
    }
}