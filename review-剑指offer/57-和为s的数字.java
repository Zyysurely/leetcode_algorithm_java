import java.util.*;

class Solution_offer_57 {
    public int[] sumOfS(int[] nums, int s) {
        int i=0, j=nums.length-1;
        int[] res = new int[2];
        while(i<j) {
            int sum = nums[i] + nums[j];
            if(sum == s) {
                res[0] = nums[i];
                res[1] = nums[j];
                return res;
            }
            if(sum < s) i++;
            else j--;
        }
        return res;
    }

    // 连续的正整数序列
    public List<List<Integer>> sumOfSequence(int s) {
        List<List<Integer>> res = new ArrayList<>();
        int first = 1, last = 2, sum=3; // 初始化最小的

        while(last < s) {
            if(sum < s) {
                last++;
                sum += last;
            } 
            else if(sum > s){
                sum -= first;
                first++;
            } else {
                List<Integer> cur = new ArrayList<>();
                for(int i=first; i<=last; i++) cur.add(i);
                res.add(cur);
                sum -= first;
                first++;
                last--;
                sum += last;
            }
        }
        return res;
    }
}