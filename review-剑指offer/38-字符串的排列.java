
import java.util.*;

class Solution_offer_38 {
    List<List<Character>> res = new ArrayList<>();
    List<Character> cur = new ArrayList<>();
    public List<List<Character>> permutation(char[] inp) {
        if(inp.length == 0) return null;
        helper(inp, 0);
        return res;
    }

    private void helper(char[] inp, int index) {
        if(index == inp.length) res.add(new ArrayList<>(cur));
        HashMap<Character, Boolean> check = new HashMap<>();
        for(int i=index; i<inp.length; i++) {
            if(!check.containsKey(inp[i])){
                swap(inp, index, i);
                cur.add(inp[index]);
                check.put(inp[index], true);
                helper(inp, index+1);
                swap(inp, index, i);
                cur.remove(cur.size() -1);
            }
        }
    }

    private void swap(char[] inp, int i, int j) {
        char temp = inp[i];
        inp[i] = inp[j];
        inp[j] = temp;
    }
}