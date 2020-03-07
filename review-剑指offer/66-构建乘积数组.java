import java.util.*;

class Solution_offer_66 {
    public int[] multiplyList(int[] nums) {
        if(nums.length == 0) return null;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        // 从前往后
        for(int i=1; i<nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int mul = 1;
        // 从后往前
        for(int i=nums.length-2; i>=0 ;i--) {
            mul *= nums[i+1];
            res[i] *= mul;
        }
        return res;
    }
}