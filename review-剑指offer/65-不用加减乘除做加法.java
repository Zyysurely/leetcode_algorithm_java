class Solution_offer_65 {
    public int add(int a, int b) {
        return b==0 ? a : add(a^b, (a&b) << 1);
    }
}