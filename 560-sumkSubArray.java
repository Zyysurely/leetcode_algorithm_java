import java.util.*;

// 就是一个差的dp问题，跟那个树中的思想是一样的，不过树需要回溯
class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count=0;
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            count += nums[i];
            if(map.containsKey(count-k)) {res+=map.get(count-k);}
            // 有几种可以构成这个的组合
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return res;
    }
}