class Solution_461 {
    public int hammingDistance(int x, int y) {
        int res = x^y;
        // res中有多少个1
        int count=0;
        while(res!=0) {
            res = (res-1)&res;
            count++;
        }
        return count;
    }
}