import java.util.*;


class Solution_49 {
    // 其中还有种方法就是按照质数，乘积一样时成立，为26个字母分配对应的质数，或者为每个string Arrays.Sort();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> res = new ArrayList<>();
        int len = strs.length;
        for(int i=0; i<len; i++) {
            String key = getKey(strs[i]);
            if(map.get(key)!= null) {
                map.get(key).add(strs[i]);
            } else {
                List<String> cur = new ArrayList<String>();
                cur.add(strs[i]);
                map.put(key, cur);
            }
        }
        for(HashMap.Entry<String, List<String>> entry: map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    
    public String getKey(String s) {
        int[] count=new int[26];
        Arrays.fill(count, 0);
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++) {
            res.append(count[i]);
        }
        return res.toString();
    }
}