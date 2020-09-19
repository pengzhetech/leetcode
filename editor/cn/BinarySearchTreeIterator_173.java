//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 249 👎 0

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    public static void main(String[] args) {
        BSTIterator solution = new BinarySearchTreeIterator_173().new BSTIterator(null);
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
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {

            // Stack for the recursion simulation
            this.stack = new Stack<TreeNode>();

            // Remember that the algorithm starts with a call to the helper function
            // with the root node as the input
            this._leftmostInorder(root);
        }

        private void _leftmostInorder(TreeNode root) {

            // For a given node, add all the elements in the leftmost branch of the tree
            // under it to the stack.
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            // Node at the top of the stack is the next smallest element
            TreeNode topmostNode = this.stack.pop();

            // Need to maintain the invariant. If the node has a right child, call the
            // helper function for the right child
            if (topmostNode.right != null) {
                this._leftmostInorder(topmostNode.right);
            }

            return topmostNode.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return this.stack.size() > 0;
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}