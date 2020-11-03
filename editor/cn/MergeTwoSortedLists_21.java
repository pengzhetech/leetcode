//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists_21().new Solution();
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);

        System.out.println(solution.mergeTwoLists(l1, null));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;f\
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode dummy = new ListNode(-1);

            ListNode cur = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                cur = cur.next;
            }

            if (l1 != null) cur.next = l1;
            if (l2 != null) cur.next = l2;
            return dummy.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);

        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}