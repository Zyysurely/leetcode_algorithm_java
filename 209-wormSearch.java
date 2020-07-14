class Solution {
    // 虫取法（也就是滑动窗口），双指针，左闭右开
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 1 && nums[0] >= s) {
            return 1;
        }
        if(nums.length == 1 || nums.length == 0) return 0;
        int l=0, r=0, res=nums.length+1;
        int sum = 0;
        while(r<nums.length) {
            sum += nums[r];
            while(sum>=s) {
                res = Math.min(res, r-l+1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        if(res == nums.length+1) return 0;
        return res;
    }
}

// 或者用累积和的结果做二分查找 nlogn