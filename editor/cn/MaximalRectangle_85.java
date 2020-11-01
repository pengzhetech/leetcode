//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划 
// 👍 519 👎 0

import java.util.Arrays;

public class MaximalRectangle_85 {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle_85().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int maxArea = 0;
            int cols = matrix[0].length;
            int[] leftLessMin = new int[cols];
            int[] rightLessMin = new int[cols];
            Arrays.fill(leftLessMin, -1); //初始化为 -1，也就是最左边
            Arrays.fill(rightLessMin, cols); //初始化为 cols，也就是最右边
            int[] heights = new int[cols];
            for (int row = 0; row < matrix.length; row++) {
                //更新所有高度
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == '1') {
                        heights[col] += 1;
                    } else {
                        heights[col] = 0;
                    }
                }
                //更新所有leftLessMin
                int boundary = -1; //记录上次出现 0 的位置
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == '1') {
                        //和上次出现 0 的位置比较
                        leftLessMin[col] = Math.max(leftLessMin[col], boundary);
                    } else {
                        //当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
                        leftLessMin[col] = -1;
                        //更新 0 的位置
                        boundary = col;
                    }
                }
                //右边同理
                boundary = cols;
                for (int col = cols - 1; col >= 0; col--) {
                    if (matrix[row][col] == '1') {
                        rightLessMin[col] = Math.min(rightLessMin[col], boundary);
                    } else {
                        rightLessMin[col] = cols;
                        boundary = col;
                    }
                }

                //更新所有面积
                for (int col = cols - 1; col >= 0; col--) {
                    int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
                    maxArea = Math.max(area, maxArea);
                }

            }
            return maxArea;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}