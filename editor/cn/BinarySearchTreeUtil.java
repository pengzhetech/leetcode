/**
 * @author pengzhe
 * @date 2020/7/16 22:57
 * @description
 */

public class BinarySearchTreeUtil {

    static TreeNode root;

    //根据数组 arr 中的元素构造一棵二叉排序树
    public static TreeNode buildTree(int[] arr) {
        for (int node : arr) {
            insert(node);
        }
        return root;
    }

    private static void insert(int val) {
        root = insert(root, val);
    }

    private static TreeNode insert(TreeNode root, int val) {
        //递归的结束条件.base condition
        if (root == null)
            return new TreeNode(val);
        if (root.val > val) {
            root.left = insert(root.left, val);
        } else if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;//若某结点的左右孩子不空,在后续的递归调用中该结点的左右指针是不会变的.
    }

    // 中序遍历输出
    public static void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + "\t");
            inOrder(node.right);

        }
    }

    // 先序遍历输出-递归
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 后序递归遍历输出
    public static void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + "\t");

        }
    }

    public static void main(String[] args) {
        int[] treeNodes = {2, 4, 5, 1, 3};
        //inOrder(buildTree(treeNodes));
      //  preOrder(buildTree(treeNodes));
        inOrder(buildTree(treeNodes));
    }

}
