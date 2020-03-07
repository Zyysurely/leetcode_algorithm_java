class Solution_offer_42 {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums) {
            sum = sum<=0 ? num : sum+num;
            max = Math.max(max, sum);
        }
        return max;
    }
}