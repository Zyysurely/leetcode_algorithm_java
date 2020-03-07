

class Solution_offer_53{
    public int numInSortedList(int[] nums, int k) {
        int first = binary(nums, k);
        int last = binary(nums, k+1);
        if(first == nums.length || nums[first] != k) return 0;
        return last - first;
    }

    private int binary(int[] nums, int k) {
        int l=0, r=nums.length-1;
        while(l<r) {
            int mid = (l+r)/2;
            if(nums[mid] >= k) r = mid;
            else l = mid+1;  
        }
        return l;
    }
}