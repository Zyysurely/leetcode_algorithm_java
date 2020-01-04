class Solution_169 {
    // 会去除相同数量的众数和非众数，众数为+1，总和count会大于0，摩尔投票法
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == maj) {
                count ++;
            } else {
                count --;
            }
            if(count == 0) {
                maj = nums[i];
                count ++;
            }
        }
        return maj;
    }
}