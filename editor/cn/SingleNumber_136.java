//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1378 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumber_136 {
    public static void main(String[] args) {
        Solution solution = new SingleNumber_136().new Solution();
        int[] numbers = {4, 3, 3, 1, 1, 2, 2};
        solution.singleNumber(numbers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 哈希表法
     */
    class Solution {
        public int singleNumber(int[] nums) {
            AtomicInteger res = new AtomicInteger();
            if (nums == null || nums.length == 0) return res.get();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                Integer number = map.get(i);
                int count = number == null ? 1 : ++number;
                map.put(i, count);
            }
            map.forEach((key, value) -> {
                if (map.get(key) == 1) res.set(key);
            });
            return res.get();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * 看不懂的位运算
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}