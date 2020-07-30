//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 391 👎 0

public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum_209().new Solution();
    }

    /**
     *定义两个指针 \textit{start}start 和 \textit{end}end 分别表示子数组的开始位置和结束位置，维护变量 \textit{sum}sum 存储子数组中的元素和（即从 \text{nums}[\textit{start}]nums[start] 到 \text{nums}[\textit{end}]nums[end] 的元素和）。
     *
     * 初始状态下，\textit{start}start 和 \textit{end}end 都指向下标 00，\textit{sum}sum 的值为 00。
     *
     * 每一轮迭代，将 \text{nums}[end]nums[end] 加到 \textit{sum}sum，如果 \textit{sum} \ge ssum≥s，则更新子数组的最小长度（此时子数组的长度是 \textit{end}-\textit{start}+1end−start+1），然后将 \text{nums}[start]nums[start] 从 \textit{sum}sum 中减去并将 \textit{start}start 右移，直到 \textit{sum} < ssum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 \textit{end}end 右移
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;
            int start = 0, end = 0;
            int sum = 0;
            while (end < n) {
                sum += nums[end];
                while (sum >= s) {
                    ans = Math.min(ans, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}