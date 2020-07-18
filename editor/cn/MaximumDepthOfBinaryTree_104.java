//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 607 👎 0

import javafx.util.Pair;

import java.util.LinkedList;

public class MaximumDepthOfBinaryTree_104 {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree_104().new Solution();
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //BFS的层次遍历思想，记录二叉树的层数，
            //遍历完，层数即为最大深度
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                maxDepth++;
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.pollFirst();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return maxDepth;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    /**
     * DFS迭代实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<>(root, 1));
        int maxDepth = 0;
        //DFS实现前序遍历，每个节点记录其所在深度
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            ;
            //DFS过程不断比较更新最大深度
            maxDepth = Math.max(maxDepth, pair.getValue());
            //记录当前节点所在深度
            int curDepth = pair.getValue();
            //当前节点的子节点入栈，同时深度+1
            if (node.right != null) {
                stack.push(new Pair<>(node.right, curDepth + 1));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, curDepth + 1));
            }
        }
        return maxDepth;
    }

    /**
     * 递归实现二叉树最大深度
     * 时间复杂度O(n)
     * 空间复杂度:线性表最差O(n)、二叉树完全平衡最好O(logn)
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth(TreeNode root) {
        //递归退出条件，到叶子节点
        if (root == null) {
            return 0;
        }
        //计算左子树最大深度
        int leftMaxDepth = maxDepth(root.left);
        //计算右子树最大深度
        int rightMaxDepth = maxDepth(root.right);
        //以某个节点为根节点的数的最大深度为max
        //max=max(leftMaxDepth,rightMaxDepth)+1
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

}


