//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。 
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。 
//
// 返回一个符合上述规则的链表的列表。 
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ] 
//
// 示例 1： 
//
// 
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.ne
//xt.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
// 
//
// 示例 2： 
//
// 
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示: 
//
// 
// root 的长度范围： [0, 1000]. 
// 输入的每个节点的大小范围：[0, 999]. 
// k 的取值范围： [1, 50]. 
// 
//
// 
// Related Topics 链表

import java.util.Arrays;

public class SplitLinkedListInParts_725 {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts_725().new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode listNode = new ListNode(arr);
        System.out.println(Arrays.toString(solution.splitListToParts(listNode, 3)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int n = 0;
            ListNode current = root;
            //确定链表共有多少个节点
            while (current != null) {
                n++;
                current = current.next;
            }
            /**
             * 分割之后链表的节点个数，前mod个链表的节点个数为size+1，之后的为size
             * 若N<k,则前面每个链表为一个元素，后面的为空
             */
            int mod = n % k;
            int size = n / k;
            ListNode[] result = new ListNode[k];
            current = root;
            //给ListNode[]数组的每个链表元素循环赋值
            for (int i = 0; current != null && i < k; i++) {
                result[i] = current;
                int currentSize = size;
                if (mod > 0) {
                    currentSize = currentSize + 1;
                    mod--;
                }
                for (int j = 0; j < currentSize - 1; j++) {
                    current = current.next;
                }
                //ListNode[]数组里的每个链表元素结尾要指向null;
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
