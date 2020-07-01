//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表

public class RemoveDuplicatesFromSortedListIi_82 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi_82().new Solution();
        int[] numbers = {1, 2, 3, 3, 4, 4, 5};
        ListNode listNode = new ListNode(numbers);
        System.out.println("原链表::" + listNode);
        System.out.println("后链表::" + solution.deleteDuplicates(listNode));
        ;

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    ListNode temp = cur.next;
                    while (temp.val == temp.next.val) {
                        temp = temp.next;
                    }
                    cur.next = temp.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}