//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 352 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths_257 {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths_257().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<String>();
            if (root == null) {
                return paths;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
            Queue<String> pathQueue = new LinkedList<String>();

            nodeQueue.offer(root);
            pathQueue.offer(Integer.toString(root.val));

            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                String path = pathQueue.poll();

                if (node.left == null && node.right == null) {
                    paths.add(path);
                } else {
                    if (node.left != null) {
                        nodeQueue.offer(node.left);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.left.val).toString());
                    }

                    if (node.right != null) {
                        nodeQueue.offer(node.right);
                        pathQueue.offer(new StringBuffer(path).append("->").append(node.right.val).toString());
                    }
                }
            }
            return paths;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}