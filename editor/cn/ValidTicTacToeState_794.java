//用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。 
//
// 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（" "）中。 
// 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。 
// “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//示例 1:
//输入: board = ["O  ", "   ", "   "]
//输出: false
//解释: 第一个玩家总是放置“X”。
//
//示例 2:
//输入: board = ["XOX", " X ", "   "]
//输出: false
//解释: 玩家应该是轮流放置的。
//
//示例 3:
//输入: board = ["XXX", "   ", "OOO"]
//输出: false
//
//示例 4:
//输入: board = ["XOX", "O O", "XOX"]
//输出: true
// 
//
// 说明: 
//
// 
// 游戏板 board 是长度为 3 的字符串数组，其中每个字符串 board[i] 的长度为 3。 
// board[i][j] 是集合 {" ", "X", "O"} 中的一个字符。 
// 
// Related Topics 递归 数学 
// 👍 24 👎 0

public class ValidTicTacToeState_794 {
    public static void main(String[] args) {
        Solution solution = new ValidTicTacToeState_794().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int xCount = 0, oCount = 0;
            for (String row : board)
                for (char c : row.toCharArray()) {
                    if (c == 'X') xCount++;
                    if (c == 'O') oCount++;
                }

            if (oCount != xCount && oCount != xCount - 1) return false;
            if (win(board, 'X') && oCount != xCount - 1) return false;
            if (win(board, 'O') && oCount != xCount) return false;
            return true;
        }

        public boolean win(String[] B, char P) {
            // B: board, P: player
            for (int i = 0; i < 3; ++i) {
                if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                    return true;
                if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                    return true;
            }
            if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
                return true;
            if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
                return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}