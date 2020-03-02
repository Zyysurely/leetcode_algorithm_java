class Solution_offer_15 {
    public int numofOneinBinary(int n) {
        int count = 0;
        while(n != 0) {
            count ++;
            n &= n-1;
        }
        return count;
    }
}