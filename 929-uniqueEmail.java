import java.util.*;

class Solution_929 {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String e:emails) {
            int index = e.indexOf('@');
            String before = e.substring(0, index);
            String after = e.substring(index, e.length());
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<before.length(); i++) {
                if(before.charAt(i) == '.') continue;
                else if(before.charAt(i) == '+')break;
                else temp.append(before.charAt(i));
            }
            temp.append("@");
            temp.append(after);
            set.add(temp.toString());
        }
        return set.size();
    }
}