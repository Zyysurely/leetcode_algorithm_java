class Solution_215 {
    // 快速排序思想
    public int findKthLargest_quick(int[] nums, int k) {
        if(nums.length == 0) return 0;
        return quickSort(nums.length-k, 0, nums.length-1, nums);
    }
    public int quickSort(int k, int l, int r, int[] nums) {
        int m = partition(l, r, nums);
        if(m == k) return nums[m];
        if(m < k) {return quickSort(k, m+1, r, nums);}
        else {return quickSort(k, l, m-1, nums);}
    }
    public int partition(int l, int r, int[] nums) {
        int par = nums[l];
        int p = l;
        while(l<r) {
            while(l<r && nums[r] >= par) {r--;}
            while(l<r && nums[l] <= par) {l++;}
            swap(nums, l, r);
        }
        swap(nums, p, l);
        // 也可以直接在这里进行sort排序
        return l;
    }
    
    // 堆排序思想，面对特别大的数据量的时候，需要考虑内存限制
    public int findKthLargest_heap(int[] nums, int k) {
        int[] heap = new int[k];
        for(int i=0; i< k; i++){
            heap[i] = nums[i];
        }
        buildHeap(heap);
        for(int i=k; i<nums.length; i++) {
            int number = nums[i];
            if(number > heap[0]) {
                heap[0] = number;
                buildHeap(heap);
            }
        }
        return heap[0];
    }
    private void buildHeap(int[] heap) {
        for(int i=heap.length/2; i>=0; i--) {
            heap(i, heap.length, heap);
        }
    }
    private void heap(int i, int n, int[] heap) {
        int left = 2*i+1;
        int right = 2*i+2;
        int min = i;
        if(left<n && heap[left]<heap[min]) {
            min = left;
        }
        if(right<n && heap[right]<heap[min]) {
            min = right;
        }
        if(min != i) {
            swap(heap, i, min);
            heap(min, n, heap);
        }
    }

    // 桶排序思想
    public int findKthLargest_bucket(int[] nums, int k) {
        int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for(int i : nums){
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        int n = max - min;
        int[] bucket = new int[n + 1];
        for(int i = 0;i < nums.length;i++){
            int tmp = nums[i] - min;
            bucket[tmp]++;
        }
        for(int i = n;i >= 0;i--){
            if(bucket[i] > 0)
                k -= bucket[i];
            if(k <= 0)
              return i + min;
        }
        return 0;
    }
    
    // 快速排序升级版
    public int findKthLargest_bestQuickSort(int[] nums, int k) {
        return findKthLargestByQuickSort(nums, k);
    }
    private int findKthLargestByQuickSort(int[] nums, int k){
        k = nums.length - k;
        int left = 0, right = nums.length -1, index = -1;
        
        while(left < right){
            index = partition(nums, left, right);
            if(index == k){
                return nums[index];
            }
            if(index > k){
                right = index - 1;
            }else{
                left = index + 1;
            }
            
        }
        return nums[left];
    }
    // 找最佳的分割点，用了小trick
    private int partition(int[] nums, int left, int right){
        int pivot = median3(nums, left, right);
        int i = left, j = right -1;
        while(i < j){
            while(nums[++i] < pivot){
            }
            while(nums[--j] > pivot){
            }
            if(i < j){
                swap(nums, i, j);
            }
        }
        swap(nums, i, right -1);
        return i;
    }
    private int median3(int[] nums, int left, int right){
        int mid = (left + right) / 2;
        if(nums[left] > nums[mid]){
            swap(nums, left, mid);
        }
        if(nums[mid] > nums[right]){
            swap(nums, mid, right);
        }
        
        if(nums[left] > nums[mid]){
            swap(nums, left, mid);
        }
        swap(nums, mid, right - 1);
        return nums[right - 1];
    }


    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    // public static void main(String[] args) {
    //     Solution_215 solu = new Solution_215();
    //     int[] s = new int[]{-1,2,1,-4};
    //     System.out.println(solu.findKthLargest(s, 2));
    // }
}