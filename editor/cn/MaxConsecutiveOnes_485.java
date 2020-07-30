//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 110 👎 0

public class MaxConsecutiveOnes_485 {
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnes_485().new Solution();
    }

    /**
     * 用一个计数器 count 记录 1 的数量，另一个计数器 maxCount 记录当前最大的 1 的数量。
     * 当我们遇到 1 时，count 加一。
     * 当我们遇到 0 时：
     * 将 count 与 maxCount 比较，maxCoiunt 记录较大值。
     * 将 count 设为 0。
     * 返回 maxCount。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int count = 0;
            int maxCount = 0;
            for (int num : nums) {
                if (num == 1) {
                    // Increment the count of 1's by one.
                    count += 1;
                } else {
                    // Find the maximum till now.
                    maxCount = Math.max(maxCount, count);
                    // Reset count of 1.
                    count = 0;
                }
            }
            return Math.max(maxCount, count);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}