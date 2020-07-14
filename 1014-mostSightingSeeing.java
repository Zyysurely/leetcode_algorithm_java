class Solution_1014 {
    // A[i]+i A[j]-j
    public int maxScoreSightseeingPair(int[] A) {
        int first=A[0], res=0;
        for(int i=1; i<A.length; i++) {
            res = Math.max(res, first+A[i]-i);
            first = Math.max(first, A[i]+i);
        }
        return res;
    }
}