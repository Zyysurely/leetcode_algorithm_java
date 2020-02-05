class Solution_440 {
    // 这就是一个满十叉树，因为不需要知道所有的，所有不需要递归，根据判断是不是在子树中，可以判断
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while(k>0) {
            long step=0, first = cur, last=cur+1;
            while(first<=n) {
                step += Math.min((long)n+1, last) - first;
                first *= 10;
                last *= 10;
            }
            if(step<=k) {  // 不在子树中
                ++cur;
                k-=step;
            } else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }
}