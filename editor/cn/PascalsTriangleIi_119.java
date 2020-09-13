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
        System.out.println(solution.getRow(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            if (rowIndex == 0) {
                result.add(1);
                return result;
            }
            if (rowIndex == 1) {
                result.add(1);
                result.add(1);
                return result;
            }

            result.add(1);
            result.add(1);

            for (int i = 1; i < rowIndex; i++) {
                result.add(1);
                for (int j = 0; j < i; j++) {
                    result.add(result.get(0) + result.get(1));
                    result.remove(0);
                }
                result.add(1);
                result.remove(0);
            }

            return result;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}