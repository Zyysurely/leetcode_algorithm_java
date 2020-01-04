import java.util.*;


class Solution_128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        // 每个端点值对应的连续曲线的长度
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0; i<len; i++) {
            if(!map.containsKey(nums[i])){
                int left = map.getOrDefault(nums[i]-1, 0);
                int right = map.getOrDefault(nums[i]+1, 0);
                int cur_length = left+right+1;
                map.put(nums[i], cur_length);     // 怎么赋值都可以通过，只是占个位置
                map.put(nums[i]-left, cur_length);
                map.put(nums[i]+right, cur_length);
                if(cur_length > max) max = cur_length;
            }
        }
        return max;
    }
}