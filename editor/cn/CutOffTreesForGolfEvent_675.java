//你被请来给一个要举办高尔夫比赛的树林砍树. 树林由一个非负的二维数组表示， 在这个数组中： 
//
// 
// 0 表示障碍，无法触碰到. 
// 1 表示可以行走的地面. 
// 比 1 大的数 表示一颗允许走过的树的高度. 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你被要求按照树的高度从低向高砍掉所有的树，每砍过一颗树，树的高度变为 1 。 
//
// 你将从（0，0）点开始工作，你应该返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
// [1,2,3],
// [0,0,4],
// [7,6,5]
//]
//输出: 6
// 
//
// 示例 2: 
//
// 输入: 
//[
// [1,2,3],
// [0,0,0],
// [7,6,5]
//]
//输出: -1
// 
//
// 示例 3: 
//
// 输入: 
//[
// [2,3,4],
// [0,0,5],
// [8,7,6]
//]
//输出: 6
//解释: (0,0) 位置的树，你可以直接砍去，不用算步数
// 
//
// 
//
// 提示： 
//
// 
// 1 <= forest.length <= 50 
// 1 <= forest[i].length <= 50 
// 0 <= forest[i][j] <= 10^9 
// 
// Related Topics 广度优先搜索 
// 👍 60 👎 0

import java.util.List;

public class CutOffTreesForGolfEvent_675 {
    public static void main(String[] args) {
        Solution solution = new CutOffTreesForGolfEvent_675().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cutOffTree(List<List<Integer>> forest) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}