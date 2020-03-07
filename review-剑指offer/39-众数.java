class Solution_offer_39 {
    public int moreThanHalf(int[] nums){
        if(nums.length == 0) return -1;
        int k = nums[0], count=1;
        for(int i=1; i<nums.length; i++) {
            count = nums[i]==k ? count+1 : count-1;
            if(count == 0) {
                k = nums[i];
                count = 1;
            }
        }
        return k;
    }
}