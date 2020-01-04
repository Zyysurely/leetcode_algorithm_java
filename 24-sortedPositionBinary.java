import java.util.*;

class Solution_24 {
    public int[] searchRange(int[] nums, int target) {
        // 二分法逼近左右边界
        int[] res = new int[2];
        int l=0, r=nums.length-1;
        Arrays.fill(res, -1);
        if(nums.length == 0) return res;
        // 左边界
        while(l<r) {
            int m = l+(r-l)/2;
            if(nums[m] >= target) r = m;
            else l=m+1;
        }
        if(nums[l] != target) return res;
        res[0] = l;
        r=nums.length;
        // 在左边界基础上的右边界
        while(l<r) {
            int m = l+(r-l)/2;
            if(nums[m] <= target) l = m+1;
            else r=m;
        }
        res[1] = l-1;
        return res;
    }   
}