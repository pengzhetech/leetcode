//给定一个链表，判断链表中是否有环。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。 
//
// 
//
// 示例 1： 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 
//
// 示例 2： 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 
//
// 示例 3： 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
// Related Topics 链表 双指针

public class LinkedListCycle_141 {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycle_141().new Solution();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
       // node3.next = node1;

        System.out.println("test");
        System.out.println(solution.hasCycle(node1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode lowNode = head;
            ListNode fastNode = head.next;
            while (lowNode != fastNode) {
                if (lowNode == null || fastNode == null) {
                    return false;
                }
                lowNode = lowNode.next;
                fastNode = fastNode.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}