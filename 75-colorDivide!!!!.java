class Solution_75 {
    // 快排思想
    public void sortColors(int[] nums) {
        // 三个指针，一个0指针，一个2指针，一个当前指针
        int sort1 = -1, sort2=nums.length;
        for(int i=0; i<sort2; i++) {
            if(nums[i] == 0){
                swap(nums, i, sort1+1);
                sort1++;
            }
            if(nums[i] == 2) {
                swap(nums, i, sort2-1);
                sort2--;
                // 交换过后原来的i也不能确定
                i--;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}