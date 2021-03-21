//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 523 👎 0

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum_64().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (i == 0 && j == 0) continue;
                    else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                    else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                    else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;

        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               /* if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];*/
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[rows - 1][columns - 1];
    }

}