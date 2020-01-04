// 中位数是划分成两个长度相等的子集，一个子集的元素总是的大于另一个的
class Solution_4 {
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 保证j不为负数
        if(m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int t = m; m = n; n = t;
        }
        int imin = 0, imax = m, half=(m+n+1)/2;
        while(imin <= imax) {
            int i = (imin+imax)/2;
            int j = half - i;
            if(i>imin && nums1[i-1] > nums2[j]){   // i太大
                imax = i-1;
            } else if(i<imax && nums1[i] < nums2[j-1]){   // i太小
                imin = i+1;
            } else { // 可直接返回
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j == 0) maxLeft = nums1[i-1];
                else{maxLeft = Math.max(nums1[i-1], nums2[j-1]);}
                if ( (m + n) % 2 == 1 ) { return maxLeft; }
                
                int minRight = 0;
                if(i == m) minRight = nums2[j];
                else if(j == n) minRight = nums1[i];
                else{minRight = Math.min(nums1[i], nums2[j]);}
                
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Solution_4 solu = new Solution_4();
        int[] A = new int[]{1, 2};
        int[] B = new int[]{-1, 3};
        double s= solu.findMedianSortedArrays(A, B);
        System.out.println(s);
    }
}