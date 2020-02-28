class Solution_offer_3 {

    public static int findRepeatedNum(int[] nums) {
        int len = nums.length;
        if(len < 2) return -1;
        int i = 0;
        while(i<len) {
            if(i != nums[i]) {
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(i, nums[i], nums);
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 2, 1, 2};
        System.out.println(findRepeatedNum(nums));
    }
}