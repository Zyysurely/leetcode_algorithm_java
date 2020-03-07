

class Solution_offer_11 {
    public int minInRotateList(int[] nums) {
        if(nums.length == 0) return -1;
        int l=0, r=nums.length-1;
        while(l < r) {
            int mid = (l+r)/2;
            // 当全部相等时111101，无法确定
            if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
                return minNum(nums, l, r);
            }
            if(nums[mid] <= nums[r]) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return nums[l];
    }

    private int minNum(int[] nums, int l, int r){
        for(int i=l; i<r; i++){
            if(nums[i] > nums[i+1]) return nums[i+1];
        }
        return nums[l];
    }
}