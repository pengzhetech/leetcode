//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList_83().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode listNode = solution.deleteDuplicates(head);
        System.out.println(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                /**
                 * 当有多个相同的数,找到第一个相同的时,cur指针不会移动,直到找到最后一个为止
                 */
                if (cur.next.val == cur.val) {
                    cur.next = cur.next.next;
                } else {
                    //移动指针
                    cur = cur.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}