// 双指针从前往后，类似于面积问题那题
class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        int[] res = new int[2];
        
        while(l<r) {
            int sum = numbers[l]+numbers[r];
            if(sum == target){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            } else if(sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}