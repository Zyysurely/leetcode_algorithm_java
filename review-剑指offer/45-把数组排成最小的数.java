
import java.util.*;

class Solution_offer_45{
    public String minNum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer str1, Integer str2) {
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        String s="";
        for(int j:list) {
            s += j;
        }
        return s;
    }
}