//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 908 👎 0

public class SymmetricTree_101 {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree_101().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root, root);

        }

        private boolean isMirror(TreeNode tree1, TreeNode tree2) {
            if (tree1 == null && tree2 == null) return true;
            if (tree1 == null || tree2 == null) return false;
            return tree1.val == tree2.val
                    && isMirror(tree1.left, tree2.right)
                    && isMirror(tree1.right, tree2.left);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}