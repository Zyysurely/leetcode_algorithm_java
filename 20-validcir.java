import java.util.*;

class Solution_20 {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for(int i=0; i< s.length(); i++) {
            // System.out.println(map.get(s.charAt(i)));
            if(!map.containsKey(s.charAt(i))) {
                if(!stack.empty() && stack.pop() == s.charAt(i)) {
                    map.remove(s.charAt(i));
                } else {
                    return false;
                }
            } else {
                stack.push(map.get(s.charAt(i)));
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}