//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针

public class PartitionList_86 {
    public static void main(String[] args) {
        Solution solution = new PartitionList_86().new Solution();
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode listNode = new ListNode(arr);
        System.out.println(solution.partition(listNode, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode partition(ListNode head, int x) {

            ListNode dummyMinList = new ListNode(-1);//小于x的哑节点
            ListNode curMin = dummyMinList;

            ListNode dummyMaxList = new ListNode(-2);//大于x的哑节点
            ListNode curMax = dummyMaxList;

            while (head != null) {
                if (head.val < x) {
                    curMin.next = head;//将原链表的节点放入新链表中
                    curMin = head;//新链表结点后移
                } else {
                    curMax.next = head;
                    curMax = head;
                }
                head = head.next;
            }

            curMax.next = null;
            curMin.next = dummyMaxList.next;
            return dummyMinList.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}