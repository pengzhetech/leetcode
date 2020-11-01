//给定一个未排序的整数数组，找出最长连续序列的长度。 
//
// 要求算法的时间复杂度为 O(n)。 
//
// 示例: 
//
// 输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。 
// Related Topics 并查集 数组 
// 👍 461 👎 0

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence_128().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}