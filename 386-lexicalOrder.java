import java.util.*;

class Solution_386 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1; i<10; i++) {
            dfs(n, i);
        }
        return res;
    }

    void dfs(int n, int i) {
        if(i<=n) {
            res.add(i);
            int num=i*10;
            for(int j=0; j<10; j++) {
                dfs(n, num+j);
            }
        }
    }
    
}