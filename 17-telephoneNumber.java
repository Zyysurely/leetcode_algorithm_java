import java.util.*;

class Solution_17 {
    HashMap<Character, String> map = new HashMap<Character, String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return  new ArrayList<String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return recLetter(digits, 0, digits.length()-1);
    }
    
    public List<String> recLetter(String digits, int l, int r) {
        List<String> res = new ArrayList<String>();
        String s = map.get(digits.charAt(l));
        if(r-l == 0) {
             for(int j=0; j<s.length(); j++){
                 res.add(String.valueOf(new char[]{s.charAt(j)}));
             }
            return res;
        }
        List<String> last = recLetter(digits, l+1, r);
        for(int j=0; j<s.length(); j++){
            char item = s.charAt(j);
            for(int i=0; i<last.size(); i++) {
                res.add(item + last.get(i));
            }
        }
        return res;
    }
}