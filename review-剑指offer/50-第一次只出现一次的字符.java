import java.util.BitSet;

class Solution_offer_50 {
    public int getFirst(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for( char c:str.toCharArray()) {
            if(!bs1.get(c) && !bs2.get(c)) bs1.set(c);
            else if(bs1.get(c) && !bs2.get(c)) bs2.set(c);
        }
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(bs1.get(c) && !bs2.get(c)) return i;
        }
        return -1;
    }
}