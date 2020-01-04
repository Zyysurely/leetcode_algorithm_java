class Solution_162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return 0;
        int left = 0,  right = nums.length-1;
        while(left<right) {
            int mid = (left+right)/2;
            // 因为左右两边都是负无穷，所以上坡必有坡顶！！！
            if(nums[mid] > nums[mid+1]) right = mid;
            else left = mid+1;
        }
        return left;
    }
}