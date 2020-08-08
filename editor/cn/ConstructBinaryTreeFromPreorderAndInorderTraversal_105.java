//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 576 👎 0

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal_105().new Solution();
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
    public class Solution {

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int preLen = preorder.length;
            int inLen = inorder.length;
            if (preLen != inLen) {
                throw new RuntimeException("Incorrect input data.");
            }
            return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
        }


        /**
         * 使用数组 preorder 在索引区间 [preLeft, preRight] 中的所有元素
         * 和数组 inorder 在索引区间 [inLeft, inRight] 中的所有元素构造二叉树
         *
         * @param preorder 二叉树前序遍历结果
         * @param preLeft  二叉树前序遍历结果的左边界
         * @param preRight 二叉树前序遍历结果的右边界
         * @param inorder  二叉树后序遍历结果
         * @param inLeft   二叉树后序遍历结果的左边界
         * @param inRight  二叉树后序遍历结果的右边界
         * @return 二叉树的根结点
         */
        private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                   int[] inorder, int inLeft, int inRight) {
            // 因为是递归调用的方法，按照国际惯例，先写递归终止条件
            if (preLeft > preRight || inLeft > inRight) {
                return null;
            }
            // 先序遍历的起点元素很重要
            int pivot = preorder[preLeft];
            TreeNode root = new TreeNode(pivot);
            int pivotIndex = inLeft;
            // 严格上说还要做数组下标是否越界的判断 pivotIndex < inRight
            while (inorder[pivotIndex] != pivot) {
                pivotIndex++;
            }
            root.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft,
                    inorder, inLeft, pivotIndex - 1);
            root.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight,
                    inorder, pivotIndex + 1, inRight);
            return root;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}