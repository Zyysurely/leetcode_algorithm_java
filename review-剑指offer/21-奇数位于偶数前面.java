class Solution_offer_21 {
    // 一种是直接新开辟数组复制，这个用时间换空间的写法，冒泡的思想
    public void reOrder(int[] nums) {
        for(int i=nums.length-1; i>=0; i--) {
            for(int j=0; j<i; j++) {
                if(nums[j]%2 == 0 && nums[j+1]%2 != 0) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}