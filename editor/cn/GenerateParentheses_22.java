//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1172 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses_22().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }

            StringBuilder path = new StringBuilder();
            dfs(path, n, n, res);
            return res;
        }


        /**
         * @param path  从根结点到任意结点的路径，全程只使用一份
         * @param left  左括号还有几个可以使用
         * @param right 右括号还有几个可以使用
         * @param res
         */
        private void dfs(StringBuilder path, int left, int right, List<String> res) {
            if (left == 0 && right == 0) {
                // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
                res.add(path.toString());
                return;
            }

            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }

            if (left > 0) {
                path.append("(");
                dfs(path, left - 1, right, res);
                path.deleteCharAt(path.length() - 1);
            }

            if (right > 0) {
                path.append(")");
                dfs(path, left, right - 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}