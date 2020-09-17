//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 递归 
// 👍 49 👎 0

public class NThTribonacciNumber_1137 {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber_1137().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class Tri {
        private int n = 38;
        public int[] nums = new int[n];

        int helper(int k) {
            if (k == 0) return 0;
            if (nums[k] != 0) return nums[k];

            nums[k] = helper(k - 1) + helper(k - 2) + helper(k - 3);
            return nums[k];
        }

        Tri() {
            nums[1] = 1;
            nums[2] = 1;
            helper(n - 1);
        }
    }

    class Solution {
        public Tri t = new Tri();

        public int tribonacci(int n) {
            return t.nums[n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}