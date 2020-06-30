//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 
//
// 示例 1: 
//
// 输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
// 
//
// 示例 2: 
//
// 输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL 
// Related Topics 链表 双指针

public class RotateList_61 {
    public static void main(String[] args) {
        Solution solution = new RotateList_61().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = solution.rotateRight(head, 2);
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode oldTail = head;
            //链表的长度
            int listNodeLength = 1;
            while (oldTail.next != null) {
                oldTail = oldTail.next;
                listNodeLength++;
            }
            //原链表尾节点指向头节点,形成环
            oldTail.next = head;
            //真正需要移动的步数
            k = k % listNodeLength;
            ListNode newTail = head;
            //新链表的尾结点listNodeLength-k,头节点listNodeLength-k-1
            for (int i = 0; i < listNodeLength - k - 1; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            newTail.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}