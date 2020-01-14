class Solution_384 {
    int[] origin;
    int[] cur;
    Random random = new Random();

    Solution_384(int[] nums) {
        origin = nums.clone();
        cur = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cur = origin.clone();
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = cur.length;
        for(int i=0; i<len; i++) {
            int l = random.nextInt(len-i)+i;
            swap(i, l);
        }
        return cur;
    }

    public void swap(int i, int j) {
        int temp = cur[i];
        cur[i] = cur[j];
        cur[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */