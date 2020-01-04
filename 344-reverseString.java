class Solution_344 {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i=0; i<len/2; i++) {
            swap(s, i, len-1-i);
        }
    }
    
    public void swap(char[] s, int i, int j) {
        char cur = s[i];
        s[i] = s[j];
        s[j] = cur;
    }
}