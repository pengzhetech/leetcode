//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList_19().new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        System.out.println(solution.removeNthFromEnd(listNode, 3));
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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode start = dummy;
            ListNode end = dummy;

            //快指针先走n步,此时快指针与满指针的距离正好是n
            while (n != 0) {
                start = start.next;
                n--;
            }

            //快指针到末尾时,满指针正好在倒数第n的位置
            while (start.next != null) {
                end = end.next;
                start = start.next;
            }

            end.next = end.next.next;

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}