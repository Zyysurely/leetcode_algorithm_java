class Solution_371 {
    public int getSum(int a, int b) {
        if(b == 0) return a;
        return getSum(a^b, (a&b)<<1);
    }
}
// 不用加号的加法