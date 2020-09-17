//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 351 👎 0

public class LongestUnivaluePath_687 {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath_687().new Solution();
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
        int ans = 0;    // 结果

        public int longestUnivaluePath(TreeNode root) {
            helper(root);
            return ans;
        }

        // 搜索以root为起点的最长同值路径
        // 要么经过左子树，要么经过右子树
        public int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int maxLength = 0;  // 以root为起点的最长同值路径
            int leftLength = helper(root.left);     // 以root.left为起点的最长同值路径
            int rightLength = helper(root.right);   // 以root.right为起点的最长同值路径
            // 情况2，不需要更新maxLength，但要更新结果
            if (root.left != null && root.right != null &&
                    root.val == root.left.val && root.val == root.right.val) {
                ans = Math.max(ans, leftLength + rightLength + 2);
            }
            // 从左右子树中选取最长同值路径
            if (root.left != null && root.val == root.left.val) {
                maxLength = leftLength + 1;
            }
            if (root.right != null && root.val == root.right.val) {
                maxLength = Math.max(maxLength, rightLength + 1);
            }
            // 更新结果
            ans = Math.max(ans, maxLength);
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}