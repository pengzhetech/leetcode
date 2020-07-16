//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 579 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal_94().new Solution();
        int[] treeNodes = {1, 2, 3};
        System.out.println(solution.inorderTraversal(BinarySearchTreeUtil.buildTree(treeNodes)));
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> treeNodes = new ArrayList<>();
            helper(root, treeNodes);
            return treeNodes;
        }

        private void helper(TreeNode root, List<Integer> res) {
            if (root != null) {
                if (root.left != null) {
                    helper(root.left, res);
                }
                res.add(root.val);
                if (root.right != null) {
                    helper(root.right, res);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}