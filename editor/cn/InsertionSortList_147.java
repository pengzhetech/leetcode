//对链表进行插入排序。 
//
// 
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。 
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 
//
// 
//
// 插入排序算法： 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 
//
// 示例 1： 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2： 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5
// 
// Related Topics 排序 链表

public class InsertionSortList_147 {
    public static void main(String[] args) {
        Solution solution = new InsertionSortList_147().new Solution();
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
        public ListNode insertionSortList(ListNode head) {
            ListNode newHead = new ListNode(Integer.MIN_VALUE);
            newHead.next = head;
            ListNode cur = head;
            ListNode pre = newHead;
            while (cur != null) {
                //cur.val<pre.val 发现后边的数据 < 前边的数据时候 例如 12341,重新开始扫描
                if (cur.val < pre.val) {
                    //差在这里，没有更新头部，要注意呀
                    ListNode newIndex = newHead.next;
                    ListNode newPre = newHead;
                    while (newIndex != pre && newIndex.val < cur.val) {
                        newIndex = newIndex.next;
                        newPre = newPre.next;
                    }
                    //找到位置进行节点交换位置
                    pre.next = cur.next;
                    cur.next = newIndex;
                    newPre.next = cur;
                    cur = pre.next;
                } else {
                    //cur.val>=pre.val 前边数据小于等于后边数据，说明已经排好序了，继续往前走
                    cur = cur.next;
                    pre = pre.next;
                }
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}