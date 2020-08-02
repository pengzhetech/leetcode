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
        int[] numbers = {5, 5, 5};
        ListNode listNode = new ListNode(numbers);
        System.out.println("原链表::" + listNode);
        System.out.println("后链表::" + solution.deleteDuplicates(listNode));
        ;

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 与链表的其他题目类似，为了防止删除头结点的极端情况发生，先创建空结点dummy，
     * 使dummy指向传入的head结点。
     * 然后创建cur的指针，指向链表的头部（即dummy）。
     * 接着对cur指针迭代，因为要对比cur(cur最初始的定义指向空结点)指针的下一个结点与下下一个结点的值是否相等，
     * 为了防止产生空指针异常，故退出迭代的条件为：cur.next != null && cur.next.next != null。
     * 在迭代过程中，如果cur.next.val == cur.next.next.val说明此时有重复元素，
     * 此时创建一个临时指针temp，指向cur的下一个节点，即temp指向的第一个重复元素所在的位置。
     * 通过while循环去重，去重后，temp指向的是重复元素中的最后一个位置。
     * 最后cur.next = temp.next就实现了消除重复元素。
     * 当然，如果为发现重复元素，则直接向后迭代即可。
     * 迭代完成后，返回dummy的next。
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    ListNode temp = cur.next;
                    while (temp.next != null && temp.val == temp.next.val) {
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