//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 329 👎 0

public class PartitionEqualSubsetSum_416 {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum_416().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return false;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if ((sum & 1) == 1) {
                return false;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            if (nums[0] <= target) {
                dp[nums[0]] = true;
            }
            for (int i = 1; i < len; i++) {
                for (int j = target; nums[i] <= j; j--) {
                    if (dp[target]) {
                        return true;
                    }
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}