//给定一个二叉树，返回它的 前序 遍历。 
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 330 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal_144().new Solution();
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);
            if (root.left != null) {
                dfs(root.left, res);
            }
            if (root.right != null) {
                dfs(root.right, res);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}