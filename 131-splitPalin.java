import java.util.*;

class Solution_131 {
    List<String> cur = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return res;
        helper(s, 0, s.length()-1);
        return res;
    }

    void helper(String s, int i, int j) {
        if(i > j) {
            res.add(new ArrayList<String>(cur));
             return;
        }
        for(int index=i; index<=j; index++) {
            if(isPalindrome(s, i, index)) {
                cur.add(s.substring(i, index+1));
                helper(s, index+1, j);
                cur.remove(cur.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}