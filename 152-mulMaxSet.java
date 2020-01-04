class Solution_152 {
    // 两个指针，一个保存最大的，一个保存最小的
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int t=1, l=1, max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<0) {int temp=t; t=l; l=temp;}
            t = Math.max(t*nums[i], nums[i]);
            l = Math.min(l*nums[i], nums[i]);
            
            max= Math.max(max, t);
        }
        return max;
    }
}