import java.util.*;

class Solution_300 {
    // 动态规划思想，但是需要注意并不是连续递增
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1; i<len; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    if(dp[i] > max){max = dp[i];}
                }
            }
        }
        return max;
    }

    // 二分法，将复杂度减为nlogn!!!!!!
    public int lengthOfLIS_binary(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        // Arrays.fill(dp, 1);
        int max = 0;
        // dp[i]代表的是长度为i+1的递增子序列，最小的序列尾数，dp数组一定是一个递增的数组，这里可使用二分查找来搜索
        for(int i=0; i<len; i++) {
            int l=0, r=max;
            while(l<r) {
                int mid = (l+r)/2;
                if(dp[mid] < nums[i]) l = mid+1;
                else r = mid;
            }
            dp[l] = nums[i];
            if(l == max) max++;
        }
        return max;
    }
}