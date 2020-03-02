class Solution_offer_16 {
    public double power(double base, int exp) {
        if(exp == 0) return 1;
        if(exp == 1) return base;
        boolean negative = false;
        // 正负影响
        if(exp < 0) {
            exp = -exp;
            negative = true;
        }
        double res = power(base * base, exp/2);
        // 奇偶数
        if(exp % 2 == 1) res *= base;
        return negative ? 1/res : res;
    }
}