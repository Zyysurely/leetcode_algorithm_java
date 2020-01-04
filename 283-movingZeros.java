class Solution_283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len == 0) return;
        int index = 0;
        for(int i=0; i<len; i++) {
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        while(index<len) nums[index++] = 0;
    }
}