//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 420 👎 0

public class FlattenBinaryTreeToLinkedList_114 {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList_114().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public void flatten(TreeNode root) {
            while (root != null) {
                //左子树为 null，直接考虑下一个节点
                if (root.left == null) {
                    root = root.right;
                } else {
                    // 找左子树最右边的节点
                    TreeNode pre = root.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    //将原来的右子树接到左子树的最右边节点
                    pre.right = root.right;
                    // 将左子树插入到右子树的地方
                    root.right = root.left;
                    root.left = null;
                    // 考虑下一个节点
                    root = root.right;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}