
class Solution_offer_17 {
    public void print1ToN(int n) {
        if(n<=0) return;
        char[] res = new char[n];
        dfs(res, 0);
    }

    private void dfs(char[] res, int index) {
        if(index == res.length) {System.out.println();return;}
        int first = 0;
        if(index == 0) first = 1;
        for(int i=first; i<=9; i++) {
            res[index] = (char)('0' + i);
            dfs(res, index+1);
        }
    }
}