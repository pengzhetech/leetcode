//回忆一下祖玛游戏。现在桌上有一串球，颜色有红色(R)，黄色(Y)，蓝色(B)，绿色(G)，还有白色(W)。 现在你手里也有几个球。 
//
// 每一次，你可以从手里的球选一个，然后把这个球插入到一串球中的某个位置上（包括最左端，最右端）。接着，如果有出现三个或者三个以上颜色相同的球相连的话，就把它
//们移除掉。重复这一步骤直到桌上所有的球都被移除。 
//
// 找到插入并可以移除掉桌上所有球所需的最少的球数。如果不能移除桌上所有的球，输出 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = "WRRBBW", hand = "RB"
//输出：-1
//解释：WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
// 
//
// 示例 2： 
//
// 
//输入：board = "WWRRBBWW", hand = "WRBRW"
//输出：2
//解释：WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
// 
//
// 示例 3： 
//
// 
//输入：board = "G", hand = "GGGGG"
//输出：2
//解释：G -> G[G] -> GG[G] -> empty 
// 
//
// 示例 4： 
//
// 
//输入：board = "RBYYBBRRB", hand = "YRBGB"
//输出：3
//解释：RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
// 
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设桌上一开始的球中，不会有三个及三个以上颜色相同且连着的球。 
// 1 <= board.length <= 16 
// 1 <= hand.length <= 5 
// 输入的两个字符串均为非空字符串，且只包含字符 'R','Y','B','G','W'。 
// 
// Related Topics 深度优先搜索 
// 👍 62 👎 0

public class ZumaGame_488 {
    public static void main(String[] args) {
        Solution solution = new ZumaGame_488().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinStep(String board, String hand) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}