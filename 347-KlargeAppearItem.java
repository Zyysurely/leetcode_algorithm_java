import java.util.*;

class Solution_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        if(len == 0) return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<len; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i])+1);
        }
        
        int[] heap = new int[k];
        int index = 0;
        // java迭代器的使用方式
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
            // System.out.println(it.next().getKey());
            heap[index] = it.next().getKey();
            index++;
            if(index == k) break;
        }
        if(index != k) return res;
        buildHeap(heap, map);
        while(it.hasNext()) {
            int key = it.next().getKey();
            if(map.get(key) > map.get(heap[0])){
                heap[0] = key;
                buildHeap(heap, map);
            }
        }
        for(int i=0; i<k; i++) {
            res.add(heap[i]);
        }
        return res;
    }

    // 小顶堆求k大的
    void buildHeap(int[] nums, HashMap<Integer, Integer> map) {
        for(int i=(nums.length-1)/2; i>=0; i--) {
            fitDown(nums, i, map);
        }
    }

    // 建堆时向下fit
    void fitDown(int[] nums, int root, HashMap<Integer, Integer> map) {
        int left = root*2+1;
        int right = root*2+2;
        int min=root;
        if(left<nums.length && map.get(nums[left])<map.get(nums[min])) min=left;
        if(right<nums.length && map.get(nums[right])<map.get(nums[min])) min=right;
        if(min != root) {
            swap(nums, min, root);
            fitDown(nums, min, map);
        }
    }

    void swap(int[] nums, int l, int r) {
        int temp=nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}