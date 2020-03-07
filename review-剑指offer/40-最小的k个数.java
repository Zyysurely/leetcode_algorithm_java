import java.util.*;

class Solution_offer_40 {
    List<Integer> res = new ArrayList<>();
    // 快排的结果，需要修改原数组
    public List<Integer> kthMin(int[] nums, int k) {
        if(nums.length < k) return null;
        quickSort(nums, k-1);
        for(int i=0; i<k; i++) {
            res.add(nums[i]);
        }
        return res;
    }
    private void quickSort(int[] nums, int k) {
        int l=0, r=nums.length-1;
        while(l < r) {
            int index = partition(nums, l, r);
            if(index == k) break;
            if(index < k) l=index+1;
            else r=index-1;
        }
    }
    private int partition(int[] nums, int l, int r) {
        int cur = nums[l];
        int p = l;
        while(l<r) {
            while(l<r && nums[r]>=cur) r--;
            while(l<r && nums[l]<=cur) l++;
            swap(nums, l, r);
        }
        swap(nums, p, l);
        return l;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 大顶堆维护的k个
    public List<Integer> kthMinHeap(int[] nums, int k) {
        if(nums.length < k) return null;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> (o2-o1));
        for(int num : nums) {
            heap.add(num);
            if(heap.size() > k) heap.poll();
        }
        return new ArrayList<>(heap);
    }
}