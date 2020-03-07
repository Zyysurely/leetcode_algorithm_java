class Solution_offer_20 {
    public boolean isNumertic(char[] str) {
        if(str == null || str.length == 0) return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}