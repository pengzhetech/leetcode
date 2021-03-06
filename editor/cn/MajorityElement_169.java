//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 669 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement_169 {
    public static void main(String[] args) {
        Solution solution = new MajorityElement_169().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, Integer> countNums(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                if (!counts.containsKey(num)) {
                    counts.put(num, 1);
                } else {
                    counts.put(num, counts.get(num) + 1);
                }
            }
            return counts;
        }

        public int majorityElement(int[] nums) {
            Map<Integer, Integer> counts = countNums(nums);

            Map.Entry<Integer, Integer> majorityEntry = null;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
                }
            }

            return majorityEntry.getKey();
        }

        public int test(int[] nums) {
            Map<Integer, Long> map = Arrays.stream(nums).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            long limit = nums.length >> 1;
            for (Map.Entry<Integer, Long> entry : map.entrySet())
                if (entry.getValue() > limit)
                    return entry.getKey();
            return -1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}