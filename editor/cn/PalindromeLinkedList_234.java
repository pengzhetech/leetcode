//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList_234().new Solution();
        int[] arr = {1, 2, 4, 2, 1};
        ListNode listNode = new ListNode(arr);
        boolean palindrome = solution.isPalindrome(listNode);
        System.out.println(palindrome);
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
    /**
     * 避免使用 O(n)O(n) 额外空间的方法就是改变输入。
     * <p>
     * 我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较。
     * 比较完成后我们应该将链表恢复原样。虽然不需要恢复也能通过测试用例，
     * 因为使用该函数的人不希望链表结构被更改。
     * <p>
     * 算法：
     * <p>
     * 我们可以分为以下几个步骤：
     * <p>
     * 找到前半部分链表的尾节点。
     * 反转后半部分链表。
     * 判断是否为回文。
     * 恢复链表。
     * 返回结果。
     * 执行步骤一，我们可以计算链表节点的数量，然后遍历链表找到前半部分的尾节点。
     * <p>
     * 或者可以使用快慢指针在一次遍历中找到：慢指针一次走一步，快指针一次走两步，快慢指针同时出发。当快指针移动到链表的末尾时，慢指针到链表的中间。通过慢指针将链表分为两部分。
     * <p>
     * 若链表有奇数个节点，则中间的节点应该看作是前半部分。
     * <p>
     * 步骤二可以使用在反向链表问题中找到解决方法来反转链表的后半部分。
     * <p>
     * 步骤三比较两个部分的值，当后半部分到达末尾则比较完成，可以忽略计数情况中的中间节点。
     * <p>
     * 步骤四与步骤二使用的函数相同，再反转一次恢复链表本身。
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null) return false;

            ListNode endOfFirstHalf = endOfFirstHalf(head);
            ListNode second = endOfFirstHalf.next;

            ListNode reversedSecond = reverseList(second);


            ListNode p1 = head;
            ListNode p2 = reversedSecond;
            while (p2.next != null) {
                if (p1.val != p2.val) return false;
                p1 = p1.next;
                p2 = p2.next;
            }

            return true;
        }

        private ListNode endOfFirstHalf(ListNode head) {

            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverseList(ListNode head) {

            ListNode prev = null;
            ListNode cur = head;

            while (cur!= null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int front = 0;
        int end = list.size() - 1;

        while (front < end) {
            if (!list.get(front).equals(list.get(end))) {
                return false;
            }
            front++;
            end--;
        }
        return true;
    }
}