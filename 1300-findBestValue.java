class Solution_1300 {
    public int findBestValue(int[] arr, int target) {
        int l=target/arr.length, r=0;
        for(int a:arr) r = Math.max(r, a);
        // 二分查找这样的一个整数value
        while(l<=r) {
            int mid = l+(r-l)/2;
            int s = sum(arr, mid);
            if(s==target) return mid;
            if(s<target) l=mid+1;
            else r=mid-1;
        }
        if(Math.abs(sum(arr, l)-target) < Math.abs(sum(arr, r)-target)) return l;
        return r;
    }

    private int sum(int[] num, int mid) {
        int res = 0;
        for(int n:num) {
            if(n>mid) res += mid;
            else res += n;
        }
        return res;
    }
}