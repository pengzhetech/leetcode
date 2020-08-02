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
     * 第一步：找到待反转节点的前一个节点。
     * 第二步：反转m到n这部分。
     * 第三步：将反转的起点的next指向反转的后面一部分。
     * 第四步：将第一步找到的节点指向反转以后的头节点。
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {

            if (head == null) return null;

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode cur = dummy;

            //将cur指向待反转的前一个节点,dummy节点不算在索引位置内
            for (int i = 1; i < m; i++) {
                cur = cur.next;
            }

            //反转m-n间的链表

            //m-n间链表的头节点
            ListNode curr = cur.next;

            //m-n反转后的头结点
            ListNode prev = null;

            //找到n的后一个节点,为了将m-n反转后的尾结点指向他
            ListNode next = null;

            for (int j = m; j <= n; j++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            cur.next.next = next;

            cur.next = prev;

            return dummy.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

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