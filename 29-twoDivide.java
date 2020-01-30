class Solution_29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        boolean negative = (dividend ^ divisor) < 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        // 因为转正之后会突出限制
        long end = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);
        int result = 0;
        for(int i=31; i>=0; i--) {
            if((end>>i)>=sor) {
                result += 1<<i;
                end -= sor<<i;
            }
        }
        if(negative) return -result;
        return result;
    }
}