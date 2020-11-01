//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索 
// 👍 605 👎 0

public class BinaryTreeMaximumPathSum_124 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeMaximumPathSum_124().new Solution();
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
        int maxSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxGain(root);
            return maxSum;
        }

        public int maxGain(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // 递归计算左右子节点的最大贡献值
            // 只有在最大贡献值大于 0 时，才会选取对应子节点
            int leftGain = Math.max(maxGain(node.left), 0);
            int rightGain = Math.max(maxGain(node.right), 0);

            // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            int priceNewpath = node.val + leftGain + rightGain;

            // 更新答案
            maxSum = Math.max(maxSum, priceNewpath);

            // 返回节点的最大贡献值
            return node.val + Math.max(leftGain, rightGain);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}