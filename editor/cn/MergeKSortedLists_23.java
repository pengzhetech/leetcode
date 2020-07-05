//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists_23 {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists_23().new Solution();
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
        public ListNode mergeKLists(ListNode[] lists) {
            Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }

            ListNode dummyHead = new ListNode(0);
            ListNode tail = dummyHead;
            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();
                tail.next = minNode;
                tail = minNode;
                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }

            return dummyHead.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}