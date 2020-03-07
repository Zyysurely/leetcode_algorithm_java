import java.util.*;

class Solution_offer_48 {
    public int notCompliSubstr(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int curLen = 0, max = 0;
        for(int i=0; i<s.length(); i++) {
            int cur = index[s.charAt(i)];
            if(cur == -1 || i-cur > curLen) {
                curLen++;
            } else {
                if(curLen > max) max = curLen;
                curLen = i-cur;
            }
            index[s.charAt(i)] = i;
        }
        // 最后的需要注意
        max = Math.max(max, curLen);
        return max;
    }
}