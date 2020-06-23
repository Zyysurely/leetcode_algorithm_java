class Solution_56 {
    // 例如公交车站覆盖区域的问题，可以这样解决
    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        int[][] nu = new int[0][0];
        if(row == 0 || intervals[0].length == 0) return nu;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 先排序
        quickSort(intervals, 0, row-1);
        int left=intervals[0][0], right=intervals[0][1];
        for(int i=1; i<row; i++) {
            if(intervals[i][0] <= right && intervals[i][1] > right) {
                if(intervals[i][0] < left) left = intervals[i][0];
                right =  intervals[i][1];
            } else if (intervals[i][0] > right) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(left);
        temp.add(right);
        res.add(temp);
        int s = res.size();
        int[][] re = new int[s][2];
        for(int i=0; i<s; i++) {
            re[i][0] = res.get(i).get(0);
            re[i][1] = res.get(i).get(1);
        }
        return re;
    }
    
    public void quickSort(int[][] intervals, int l, int r) {
        if(l>=r) return;
        int par = partition(intervals, l, r);
        quickSort(intervals, l, par-1);
        quickSort(intervals, par+1, r);
    }
    
    public int partition(int[][] intervals, int l, int r) {
        int par = intervals[l][0];
        int index = l;
        while(l != r) {
            while(l<r && intervals[r][0] >= par) r--;
            while(l<r && intervals[l][0] <= par) l++;
            if(l<r){
                swap(intervals, l, r);
            }
        }
        swap(intervals, l, index);
        return l;
    }
    
    public void swap(int[][] intervals, int i, int j) {
        int[] temp = intervals[i];
        intervals[i] = intervals[j];
        intervals[j] = temp;
    }
}