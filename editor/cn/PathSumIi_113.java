//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 370 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSumIi_113 {
    public static void main(String[] args) {
        Solution solution = new PathSumIi_113().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            Deque<Integer> path = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();
            dfs(root, sum, path, res);
            return res;
        }

        private void dfs(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {

            if (node == null) return;

            // 递归终止条件 2
            if (node.val == sum && node.left == null && node.right == null) {
                // 当前结点的值还没添加到列表中，所以要先添加，然后再移除
                path.addLast(node.val);
                res.add(new ArrayList<>(path));
                path.removeLast();
                return;
            }
            path.addLast(node.val);
            dfs(node.left,sum-node.val,path,res);
            dfs(node.right,sum-node.val,path,res);
            path.removeLast();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}