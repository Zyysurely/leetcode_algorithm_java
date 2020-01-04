// 注意这种通过交换排序的方法

class Solution_31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i-1] >= nums[i]) {
            i--;
        }
        if(i == 0) {
            // 逆序的情况
            for(int k=0; k<nums.length/2; k++) {
                swap(nums, k, nums.length-1-k);
            }
            return;
        }
        // 有倒序的右边找正好大于j-1的数
        int r = nums.length-1;
        while(r>i) {
            if(nums[r] > nums[i-1]) break;
            r--;
        }
        swap(nums, r, i-1);
        // 后面逆序的正序
        for(int k=i; k<(i+nums.length)/2; k++){
            swap(nums, k, nums.length-1-k+i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}