//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 164 👎 0

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi_119 {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi_119().new Solution();
        System.out.println(solution.generate(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<Integer> generate(int rowIndex) {
            List<Integer> ans = new ArrayList<>();

            if (rowIndex == 1) {
                ans.add(1);
                return ans;
            }

            if (rowIndex == 2) {
                ans.add(1);
                ans.add(1);
                return ans;
            }

            int x;
            List<Integer> last = generate(rowIndex - 1);
            for (int i = 0; i < rowIndex; i++) {
                if (i == 0 || i == rowIndex - 1) {//一行的第一个数跟最后一个数都是1
                    x = 1;
                } else {//上一行的两个数相加
                    x = last.get(i - 1) + last.get(i);
                }
                ans.add(x);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}