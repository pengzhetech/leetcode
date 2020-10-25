//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 
// 👍 501 👎 0

import java.util.LinkedList;

public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree_226().new Solution();
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
        /**
         * 递归解法
         *
         * @param root
         * @return
         */
        public TreeNode invertTree(TreeNode root) {
            //递归函数的终止条件，节点为空时返回
            if (root == null) {
                return null;
            }
            //下面三句是将当前节点的左右子树交换
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;
            //递归交换当前节点的 左子树
            invertTree(root.left);
            //递归交换当前节点的 右子树
            invertTree(root.right);
            //函数返回时就表示当前这个节点，以及它的左右子树
            //都已经交换完了
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();

            TreeNode right = treeNode.right;
            treeNode.left = right;
            treeNode.right = treeNode.left;

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }

        return root;
    }


}