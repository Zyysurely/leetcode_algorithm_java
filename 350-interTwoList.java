import java.util.*;

class Solution_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> listRes = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0; i<nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                if(map.get(nums2[i]) > 0) {
                    listRes.add(nums2[i]);
                }
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] res = new int[listRes.size()];
        for(int i=0; i<listRes.size(); i++) {
            res[i] = listRes.get(i);
        }
        return res;
    }
}