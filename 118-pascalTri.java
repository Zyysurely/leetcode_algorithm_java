import java.util.*;

class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        ArrayList<Integer> tempLast =  new ArrayList<Integer>();
        tempLast.add(1);
        res.add(tempLast);
        for(int i=2; i<=numRows; i++) {
            ArrayList<Integer> temp =  new ArrayList<Integer>();
            temp.add(1);
            for(int j=2; j<i; j++) {
                temp.add(tempLast.get(j-2) + tempLast.get(j-1));
            }
            temp.add(1);
            res.add(temp);
            tempLast = temp;
        }
        return res;
    }
}