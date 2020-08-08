//给定一个二叉树 
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 179 👎 0

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeIi_117{
      public static void main(String[] args) {
           Solution solution = new PopulatingNextRightPointersInEachNodeIi_117().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class Solution {
        public Node connect(Node root) {

            if (root == null) {
                return root;
            }

            // Initialize a queue data structure which contains
            // just the root of the tree
            Queue<Node> Q = new LinkedList<Node>();
            Q.add(root);

            // Outer while loop which iterates over
            // each level
            while (Q.size() > 0) {

                // Note the size of the queue
                int size = Q.size();

                // Iterate over all the nodes on the current level
                for(int i = 0; i < size; i++) {

                    // Pop a node from the front of the queue
                    Node node = Q.poll();

                    // This check is important. We don't want to
                    // establish any wrong connections. The queue will
                    // contain nodes from 2 levels at most at any
                    // point in time. This check ensures we only
                    // don't establish next pointers beyond the end
                    // of a level
                    if (i < size - 1) {
                        node.next = Q.peek();
                    }

                    // Add the children, if any, to the back of
                    // the queue
                    if (node.left != null) {
                        Q.add(node.left);
                    }
                    if (node.right != null) {
                        Q.add(node.right);
                    }
                }
            }

            // Since the tree has now been modified, return the root node
            return root;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

  }