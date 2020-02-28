class Solution_offer_10 {
    public int frogStep(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int pre1=1, pre2=2;
        int result = 0;
        for(int i=3; i<=n; i++) {
            result = pre1+pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}