import java.util.*;

class Solution_428 {
    // 滑动窗口解法
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>(); 
        if(s.length() < p.length()) return res;                                                                                                                   
        int[] dict = new int[26];
        for(int i=0; i<p.length(); i++) {
            dict[p.charAt(i)-'a'] ++;
        }
        int[] cur = new int[26];
        for(int i=0; i<p.length()-1; i++) {
            cur[s.charAt(i)-'a'] ++;
        }
        for(int i=p.length()-1; i<s.length(); i++) {
            cur[s.charAt(i)-'a'] ++;
            if(isSame(dict, cur)) res.add(i-p.length()+1);
             cur[s.charAt(i - p.length() + 1) - 'a']--;
            // if(i>=p.length()) {
            //     cur[s.charAt(i-p.length()) - 'a'] --;
            //     System.out.println(i-p.length());
            // }
        }
        return res;
    }

    public boolean isSame(int[] a, int[] b) {
        for(int i=0; i<a.length; i++) {
            if(a[i]!=b[i]) return false;
        }
        return true;
    }
}