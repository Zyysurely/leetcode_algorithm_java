import java.util.*;

class Solution_offer_31 {
    public boolean isStackSeries(int[] push, int[] pop){
        if(push.length != pop.length) return false;
        Stack<Integer> helper  = new Stack<>();
        int l=0, r=0;
        while(l<push.length && r<push.length) {
            // 会一直push
            helper.push(push[l]);
            while(r<push.length && !helper.isEmpty() && pop[r] == helper.peek()) {
                helper.pop();
                r++;
            }
            l++;
        }
        return helper.isEmpty();
    }
}