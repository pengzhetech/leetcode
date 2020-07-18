//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 565 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal_102().new Solution();
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> res = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            //将根节点放入队列中，然后不断遍历队列
            queue.add(root);
            while (queue.size() > 0) {
                //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
                int size = queue.size();
                ArrayList<Integer> lever = new ArrayList<>();
                //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
                //如果节点的左/右子树不为空，也放入队列中
                for (int i = 0; i < size; ++i) {
                    TreeNode t = queue.remove();
                    lever.add(t.val);
                    if (t.left != null) {
                        queue.add(t.left);
                    }
                    if (t.right != null) {
                        queue.add(t.right);
                    }
                }
                //将每层的list加入最终返回结果中
                res.add(lever);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}