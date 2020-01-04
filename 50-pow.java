class Solution_50 {
    // 需要logn的算法，二分法，二进制的表示
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i=n; i!=0; i /= 2) {
            if(i % 2 !=0) {
                res *= x;
            }
            x *= x;
        }
        // 注意负数的情况
        if(n<0) return 1.0/res;
        return res;
    }
}