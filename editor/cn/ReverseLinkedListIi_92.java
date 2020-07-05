//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表

public class ReverseLinkedListIi_92 {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi_92().new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(arr);

        System.out.println(solution.reverseBetween(listNode, 2, 4));
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode g = dummyHead;
            ListNode p = dummyHead.next;

            int step = 0;
            while (step < m - 1) {
                g = g.next;
                p = p.next;
                step++;
            }

            for (int i = 0; i < n - m; i++) {
                ListNode removed = p.next;
                p.next = p.next.next;

                removed.next = g.next;
                g.next = removed;
            }

            return dummyHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}