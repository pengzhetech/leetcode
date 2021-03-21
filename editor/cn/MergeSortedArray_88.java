//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 563 👎 0

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray_88().new Solution();
        int[] array1 = {1, 2, 3, 7, 0, 0, 0};
        int m = 4;
        int[] array2 = {4, 5, 6};
        int n = 3;
        solution.merge(array1, m, array2, n);
        System.out.println(Arrays.toString(array1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            while (n > 0 && m > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[n + m - 1] = nums1[m - 1];
                    m--;
                } else {
                    nums1[n + m - 1] = nums2[n - 1];
                    n--;
                }
            }
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            System.out.println(Arrays.toString(nums1));

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}