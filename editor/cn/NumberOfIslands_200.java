//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 659 👎 0

import java.util.LinkedList;

public class NumberOfIslands_200 {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands_200().new Solution();
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        int numIslands1 = solution.numIslands(grid1);
        System.out.println(numIslands1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        int numIslands2 = solution.numIslands(grid2);
        System.out.println(numIslands2);

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 方法：广度优先遍历
     */
    public class Solution {

        private int rows;
        private int cols;

        public int numIslands(char[][] grid) {
            //           x-1,y
            //  x,y-1    x,y      x,y+1
            //           x+1,y
            int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            rows = grid.length;
            if (rows == 0) {
                return 0;
            }
            cols = grid[0].length;
            boolean[][] marked = new boolean[rows][cols];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 如果是岛屿中的一个点，并且没有被访问过
                    // 从坐标为 (i,j) 的点开始进行广度优先遍历
                    if (!marked[i][j] && grid[i][j] == '1') {
                        count++;
                        LinkedList<Integer> queue = new LinkedList<>();
                        // 小技巧：把坐标转换为一个数字
                        // 否则，得用一个数组存，在 Python 中，可以使用 tuple 存
                        queue.addLast(i * cols + j);
                        // 注意：这里要标记上已经访问过
                        marked[i][j] = true;
                        while (!queue.isEmpty()) {
                            int cur = queue.removeFirst();
                            int curX = cur / cols;
                            int curY = cur % cols;
                            // 得到 4 个方向的坐标
                            for (int k = 0; k < 4; k++) {
                                int newX = curX + directions[k][0];
                                int newY = curY + directions[k][1];
                                // 如果不越界、没有被访问过、并且还要是陆地，我就继续放入队列，放入队列的同时，要记得标记已经访问过
                                if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                    queue.addLast(newX * cols + newY);
                                    // 【特别注意】在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，你迟早都会遍历到它
                                    // 而不是在出队列的时候再标记
                                    // 【特别注意】如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的
                                    marked[newX][newY] = true;
                                }
                            }
                        }
                    }
                }

            }
            return count;
        }

        private boolean inArea(int x, int y) {
            // 等于号这些细节不要忘了
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}