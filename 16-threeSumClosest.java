import java.util.*;

class Solution_15 {
    int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closed = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(i==0 ||(i>0 && nums[i]!=nums[i-1])){
                int l=i+1, r=nums.length-1;
                int cur = target - nums[i];
                while(l<r){
                    System.out.println(cur);
                    if(cur - nums[l] - nums[r] == 0) return 0;
                    if( cur < nums[l] + nums[r]) {
                        if(Math.abs(cur - nums[l] - nums[r]) < closed){
                            closed = Math.abs(cur - nums[l] - nums[r]);
                        }
                        while(l<r && nums[l]==nums[l+1]) l++;
                        l++;
                    } else {
                        if(Math.abs(cur - nums[l] - nums[r]) <  Math.abs(closed)){
                            closed = cur - nums[l] - nums[r];
                        }
                        while(l<r && nums[r]==nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return target-closed;
    }
    public static void main(String[] args) {
        Solution_15 solu = new Solution_15();
        int[] s = new int[]{-1,2,1,-4};
        System.out.println(solu.threeSumClosest(s, 1));
    }
}