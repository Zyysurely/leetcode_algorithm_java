
import java.util.*;

class Solution_offer_61 {
    public boolean isSequence(int[] nums) {
        if(nums.length < 5) return false;
        Arrays.sort(nums);
        int sum = 0;
        for(int num:nums) {
            if(num == 0) sum++;
        }
        for(int i=sum; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) return false;
            if(nums[i+1] != nums[i]+1) {
                if(sum == 0) return false;
                nums[i+1] = nums[i] + 1;
                sum--;
            }
        }
        return true;
    }
}