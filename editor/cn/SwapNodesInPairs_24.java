//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

public class SwapNodesInPairs_24 {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs_24().new Solution();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        System.out.println(head);
        ListNode listNode = solution.swapPairs(head);
        System.out.println(listNode);
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
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {

                ListNode first = cur.next;
                ListNode second = cur.next.next;

                cur.next = second;
                first.next = second.next;
                second.next = first;

                //这样写不行,因为此时的链表的cur.next是已经交换后的节点了,我们需要的是没交换前的next
                // cur = cur.next;
                cur = first;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}