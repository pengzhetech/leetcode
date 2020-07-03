//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

public class RemoveLinkedListElements_203 {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements_203().new Solution();
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode listNode1 = solution.removeElements(listNode, 6);
        System.out.println(listNode1);
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
        public ListNode removeElements(ListNode head, int val) {

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode cur = head;
            ListNode pre = dummy;

            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                } else {
                    pre= cur;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}