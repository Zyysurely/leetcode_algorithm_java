class Solution_287 {
    //  二分法，比
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int left = 1, right=nums.length-1;
        while(left < right) {
            int mid = (left+right)/2;
            int count = 0;
            for(int num:nums ) {
                if(num <= mid) {
                    count++;
                }
            }
            if(count > mid) right = mid;
            else left=mid+1;
        }
        return left;
    }

    // 快慢指针做法，想像成带环的链表，数组的下标就是指针，找的是入口值，类似于带环的链表的问题
    public int findDuplicate_2(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int fast=0, slow=0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
               break;
            }
        }
        fast = 0;
        while(fast!=slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}