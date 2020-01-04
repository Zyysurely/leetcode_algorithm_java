import java.util.*;


class Solution_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        if(len == 0) return res;
        int i=0;
        // 交换排序，这个问题需要画图完善理解
        while(i<len) {
            if(nums[i] != i+1 && nums[i] != len+1) {
                if(nums[i] == nums[nums[i]-1]){
                    nums[i] = len+1;
                    i++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1] = temp;
                }
            } else {
                i++;
            }
        }
        for(i=0; i<len; i++) {
            if(nums[i] == len+1) res.add(i+1);
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers_2(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<Integer>();
        if(len == 0) return res;
        // 用正负完成了hash表的功能
        for(int i=0; i<len; i++) {
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] = - nums[Math.abs(nums[i])-1];}
        }
        for(int i=0; i<len; i++) {
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}