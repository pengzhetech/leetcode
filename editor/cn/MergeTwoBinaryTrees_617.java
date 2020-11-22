//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 419 👎 0

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees_617().new Solution();
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null || t2 == null) {
                return t1 == null ? t2 : t1;
            }
            return dfs(t1, t2);
        }

        TreeNode dfs(TreeNode r1, TreeNode r2) {
            // 如果 r1和r2中，只要有一个是null，函数就直接返回
            if (r1 == null || r2 == null) {
                return r1 == null ? r2 : r1;
            }
            //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
            r1.val += r2.val;
            r1.left = dfs(r1.left, r2.left);
            r1.right = dfs(r1.right, r2.right);
            return r1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(t1);
        queue.add(t2);

        while (queue.size() > 0) {
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();

            left.val += right.val;

            if (left.left != null && right.left != null) {
                queue.add(left.left);
                queue.add(right.left);
            } else if (left.left == null) {
                left.left = right.left;
            }

            if (left.right != null && right.right != null) {
                queue.add(left.right);
                queue.add(right.right);
            } else if (left.right == null) {
                left.right = right.right;
            }
        }
        return t1;
    }
}