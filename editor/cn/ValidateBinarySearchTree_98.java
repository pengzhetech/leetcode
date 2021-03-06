//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 663 👎 0

public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree_98().new Solution();
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

        long pre = -Long.MAX_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }

            if (!isValidBST(root.left)) {
                return false;
            }

            if (root.val <= pre) {
                return false;
            }

            pre = root.val;

            return isValidBST(root.right);

        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }
        return helper(node.left, lower, val);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper2(TreeNode root,Integer lower,Integer upper){
        if(root==null) return true;
        //根节点的值
        int val=root.val;
        //lower||upper为null说明是初始的root
        if(lower!=null&&lower>=val)return false;
        if(upper!=null&&upper<=val) return false;
        //左子树
        if(!helper2(root.left,lower,val))return false;
        //右子树
        if(!helper2(root.right,val,upper))return false;

        return true;
    }
}