import java.util.*;

// 回溯法理解，画出树来理解
class Solution_46 {
    // 在原数据上交换操作思想
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            one.add(nums[i]);
        }
        reSearch(res, nums.length, 0, one);
        return res;
    }
    public void reSearch(List<List<Integer>> res, int n, int first, List<Integer> one) {
        if(first == n) {
            // 此处注意要新建一个
            res.add(new ArrayList<Integer>(one));
        }
        for(int i=first; i<n; i++) {
            Collections.swap(one, first, i);
            // 生成后面的
            reSearch(res, n, first+1, one);
            // 还原
            Collections.swap(one, first, i);
        }
    }

   // 新开辟一个stack的思想
   public List<List<Integer>> permute_2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Stack<Integer> one = new Stack<Integer>();
    boolean[] visited = new boolean[nums.length];
    reSearch_2(res, visited, nums.length, 0, nums, one);
    return res;
    }
    public void reSearch_2(List<List<Integer>> res, boolean[] visited, int n, int first, int[] nums, Stack<Integer> one) {
        if(first == n) {
            // 此处注意要新建一个
            res.add(new ArrayList<Integer>(one));
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                one.push(nums[i]);
                visited[i] = true;
                reSearch_2(res, visited, n, first+1, nums, one);
                one.pop();
                visited[i] = false;
            }
    }

} 
    
    // public void swap(List<Integer> nums, int l, int r) {
    //     int tmp = nums.get;
    //     nums[l] = nums[r];
    //     nums[r] = tmp;
    // }
}