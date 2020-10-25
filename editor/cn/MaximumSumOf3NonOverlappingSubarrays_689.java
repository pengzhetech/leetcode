//给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。 
//
// 每个子数组的长度为k，我们要使这3*k个项的和最大化。 
//
// 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 示例: 
//
// 
//输入: [1,2,1,2,6,7,5,1], 2
//输出: [0, 3, 5]
//解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
//我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 注意: 
//
// 
// nums.length的范围在[1, 20000]之间。 
// nums[i]的范围在[1, 65535]之间。 
// k的范围在[1, floor(nums.length / 3)]之间。 
// 
// Related Topics 数组 动态规划 
// 👍 82 👎 0

public class MaximumSumOf3NonOverlappingSubarrays_689 {
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays_689().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}