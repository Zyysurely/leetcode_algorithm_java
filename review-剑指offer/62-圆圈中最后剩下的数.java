
class Solution_offer_62 {
    public int lastRemainNum(int n, int m) {
        if(n == 0) return -1;
        if(n == 1) return 0;
        return (lastRemainNum(n-1, m) + m) % n;
    }
}