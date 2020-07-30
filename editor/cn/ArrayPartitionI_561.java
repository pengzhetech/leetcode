//给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 
//的 min(ai, bi) 总和最大。 
//
// 示例 1: 
//
// 
//输入: [1,4,3,2]
//
//输出: 4
//解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
// 
//
// 提示: 
//
// 
// n 是正整数,范围在 [1, 10000]. 
// 数组中的元素范围在 [-10000, 10000]. 
// 
// Related Topics 数组 
// 👍 176 👎 0

import java.util.Arrays;

public class ArrayPartitionI_561 {
    public static void main(String[] args) {
        Solution solution = new ArrayPartitionI_561().new Solution();
    }

    /**
     * 为了理解这种方法，让我们从不同的角度来看待问题。我们需要形成数组元​​素的配对，使得这种配对中最小的总和最大。因此，我们可以查看选择配对中最小值的操作，比如 (a,b)(a,b) 可能会产生的最大损失 a-ba−b (如果 a > ba>b)。
     * <p>
     * 如果这类配对产生的总损失最小化，那么总金额现在将达到最大值。只有当为配对选择的数字比数组的其他元素更接近彼此时，才有可能将每个配对中的损失最小化。
     * <p>
     * 考虑到这一点，我们可以对给定数组的元素进行排序，并直接按排序顺序形成元素的配对。这将导致元素的配对，它们之间的差异最小，从而导致所需总和的最大化。
     * <p>
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}