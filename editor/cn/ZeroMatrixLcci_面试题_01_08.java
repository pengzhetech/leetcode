//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 11 👎 0

/**
 * 需要设零的行i：将该行的第一列元素matrix[i][0]设为0，表示该行需要清零；
 * 需要设为零的列j：将该列的第一行元素matrix[0][j]设为0，表示该列需要清零；
 * 根据第一行和第一列的标记，进行清零操作。
 * matrix[0][0]即表示第一行又表示第一列,需要特殊处理
 */
public class ZeroMatrixLcci_面试题_01_08 {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci_面试题_01_08().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            boolean shu = false;
            boolean hen = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        if (i == 0) {
                            hen = true;
                        }
                        if (j == 0) {
                            shu = true;
                        }
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }

            if (shu) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (hen) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}