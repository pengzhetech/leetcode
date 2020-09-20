//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 233 👎 0

import java.util.TreeSet;

public class ContainsDuplicateIii_220 {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii_220().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < nums.length; ++i) {
                // Find the successor of current element
                Integer s = set.ceiling(nums[i]);
                if (s != null && s <= nums[i] + t) return true;

                // Find the predecessor of current element
                Integer g = set.floor(nums[i]);
                if (g != null && nums[i] <= g + t) return true;

                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}