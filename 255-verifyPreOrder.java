class Solution_255 {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        if(len < 2) return true;
        return helper(preorder, 0, preorder.length-1);
    }

    boolean helper(int[] preorder, int start, int end) {
        if(start>=end) return true;
        int val = preorder[start];
        int index=start+1;
        while(index<=end && preorder[index]<val)index++;
        int mid = index;
        while(index<=end){
            if(preorder[index]<val) return false;
            index++;
        }
        return helper(preorder, start+1,mid-1) && helper(preorder, mid, end);
    }
}