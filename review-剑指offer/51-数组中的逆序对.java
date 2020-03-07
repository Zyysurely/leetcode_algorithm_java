class Solution_offer_51 {
    int res = 0;
    int[] temp;
    public int sumReversePair(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return res;
    }

    private void mergeSort(int[] nums, int i, int j){
        if(i>j) return;
        int mid = (i+j)/2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid+1, j);
        merge(nums, i, mid, j);
    }

    private void merge(int[] nums, int i, int mid, int j) {
        int k=i, s=mid+1, o=0;
        while(k<=mid || s<=j) {
            if(k>mid) temp[o] = nums[k++];
            else if(s>j) temp[o] = nums[s++];
            else if(nums[k] <= nums[s]) temp[o] = nums[k++];
            else {
                temp[o] = nums[s++];
                res += mid-k+1;
            }
            o++;
        }
        for(k =i; k<=j; k++) {
            nums[k] = temp[k];
        }
    }
}