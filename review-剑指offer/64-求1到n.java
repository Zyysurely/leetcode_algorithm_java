

class Solution_offer_64 {
    public int addToN(int n) {
        int sum = n;
        boolean b = (n>0) && ((sum += addToN(n-1)) > 0);
        return sum;
    }
}