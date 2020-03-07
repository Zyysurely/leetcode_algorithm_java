class Solution_offer_56 {
    public void findNotCompli(int[] nums) {
        int diff = 0;
        int num1=0, num2=0;
        for(int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        for(int num:nums) {
            if((num & diff) == 0){
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
    }
}