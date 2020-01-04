import java.util.*;


class Solution_89 {
     /**
        关键是搞清楚格雷编码的生成过程, G(i) = i ^ (i/2);
        如 n = 3: 
        G(0) = 000, 
        G(1) = 1 ^ 0 = 001 ^ 000 = 001
        G(2) = 2 ^ 1 = 010 ^ 001 = 011 
        G(3) = 3 ^ 1 = 011 ^ 001 = 010
        G(4) = 4 ^ 2 = 100 ^ 010 = 110
        G(5) = 5 ^ 2 = 101 ^ 010 = 111
        G(6) = 6 ^ 3 = 110 ^ 011 = 101
        G(7) = 7 ^ 3 = 111 ^ 011 = 100
        **/
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        // 必须以0开头
        res.add(0);
        if(n == 0) {
            return res;
        }
        for(int i=1; i< 1<<n; ++i) {
            res.add(i^(i/2));
        }
        return res;
    }
}