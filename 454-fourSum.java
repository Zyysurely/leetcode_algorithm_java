import java.util.*;

class Solution_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res=0;
        Map<Integer, Integer> AB = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                AB.put(A[i]+B[j], AB.getOrDefault(A[i]+B[j], 0)+1);
            }
        }

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                res += AB.getOrDefault(0-(C[i]+D[j]), 0);
            }
        }
        return res;

        
    }
}