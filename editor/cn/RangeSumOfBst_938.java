//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。 
//
// 二叉搜索树保证具有唯一的值。 
//
// 
//
// 示例 1： 
//
// 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//输出：32
// 
//
// 示例 2： 
//
// 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数量最多为 10000 个。 
// 最终的答案保证小于 2^31。 
// 
// Related Topics 树 递归 
// 👍 133 👎 0

public class RangeSumOfBst_938 {
    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst_938().new Solution();
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
    /**
     * 标签：深度优先遍历
     * 题意：这个题字面含义很难理解，本意就是求出所有 X >= L 且 X <= R 的值的和
     * 递归终止条件：
     * 当前节点为 null 时返回 0
     * 当前节点 X < L 时则返回右子树之和
     * 当前节点 X > R 时则返回左子树之和
     * 当前节点 X >= L 且 X <= R 时则返回：当前节点值 + 左子树之和 + 右子树之和
     * 注意点：通过判断X的大小能够避免遍历全部树的节点，比如下方的动图中，3 这个值就没有必要遍历
     */
    class Solution {
        public int rangeSumBST(TreeNode root, int L, int R) {
            if (root == null) {
                return 0;
            }
            if (root.val < L) {
                return rangeSumBST(root.right, L, R);
            }
            if (root.val > R) {
                return rangeSumBST(root.left, L, R);
            }
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}