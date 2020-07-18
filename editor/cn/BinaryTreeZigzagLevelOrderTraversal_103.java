//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 221 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal_103().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            //每一层结点的集合
            Deque<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                //每一层结点数值的集合
                List<Integer> lever = new LinkedList<>();
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode node = queue.poll();
                    // System.out.println(node.val);
                    if (depth % 2 == 0) {
                        lever.add(node.val);
                    } else {
                        assert node != null;
                        lever.add(0, node.val);
                    }
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(lever);
                depth++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}