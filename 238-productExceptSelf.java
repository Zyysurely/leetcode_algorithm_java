class Solution_238 {
    //  巧妙记住左右的乘积结果
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;
        for(int i=0 ;i<nums.length; i++) {
            res[i] = 1;
        }
        for(int i=0; i<nums.length; i++) {
            res[i] *= left;
            left *= nums[i];
            
            res[nums.length-1-i] *= right;
            right *= nums[nums.length-1-i];
        }
        return res;
    }
}