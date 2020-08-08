//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
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
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 395 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class PathSum_112 {
    public static void main(String[] args) {
        Solution solution = new PathSum_112().new Solution();
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
        public boolean hasPathSum(TreeNode root, int sum) {

            if (root == null) return false;

            Queue<TreeNode> queNode = new LinkedList<>();
            Queue<Integer> queVal = new LinkedList<>();

            queNode.add(root);
            queVal.add(root.val);

            while (!queNode.isEmpty()) {
                TreeNode curTreeNode = queNode.poll();
                Integer curValue = queVal.poll();

                //如果此节点时叶子节点
                if (curTreeNode.left == null && curTreeNode.right == null) {
                    if (curValue == sum) {
                        return true;
                    }
                    continue;
                }

                if (curTreeNode.left != null) {
                    queNode.add(curTreeNode.left);
                    queVal.add(curTreeNode.left.val + curValue);
                }

                if (curTreeNode.right != null) {
                    queNode.add(curTreeNode.right);
                    queVal.add(curTreeNode.right.val + curValue);
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public boolean hasPathSumDFS(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSumDFS(root.left, sum - root.val)
                || hasPathSumDFS(root.right, sum - root.val);
    }
}
