//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 442 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures_739().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] T) {

            int length = T.length;
            int[] ans = new int[length];//初始化全为0
            Deque<Integer> stack = new ArrayDeque<>();

            for (int i = 0; i < length; i++) {
                int temperature = T[i];
                while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                    Integer preIndex = stack.pop();
                    ans[preIndex] = i - preIndex;
                }
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}