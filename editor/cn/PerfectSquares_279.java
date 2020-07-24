//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 496 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares_279 {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares_279().new Solution();
        System.out.println(solution.numSquares(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {

            ArrayList<Integer> square_nums = new ArrayList<Integer>();
            for (int i = 1; i * i <= n; ++i) {
                square_nums.add(i * i);
            }

            Set<Integer> queue = new HashSet<>();
            queue.add(n);

            int level = 0;
            while (queue.size() > 0) {
                level += 1;
                Set<Integer> next_queue = new HashSet<>();

                for (Integer remainder : queue) {
                    for (Integer square : square_nums) {
                        if (remainder.equals(square)) {
                            return level;
                        } else if (remainder < square) {
                            break;
                        } else {
                            next_queue.add(remainder - square);
                        }
                    }
                }
                queue = next_queue;
            }
            return level;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}