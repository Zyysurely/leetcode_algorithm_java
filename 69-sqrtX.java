class Solution_69 {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int l=0, r=x;
        while(r - l > 1) {
            int mid = (l+r)/2;
            if(x/mid<mid) r = mid;
            else l=mid;
        }
        return l;
    }
}