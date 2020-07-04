//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表

import java.util.Stack;

public class AddTwoNumbersIi_445 {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi_445().new Solution();
        int[] arr1 = {7, 2, 4, 3};
        int[] arr2 = {5, 6, 4};

        ListNode l1 = new ListNode(arr1);
        ListNode l2 = new ListNode(arr2);

        System.out.println(solution.addTwoNumbers(l1, l2));
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while (l1 != null) {
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while (l2 != null) {
                stack2.push(l2.val);
                l2 = l2.next;
            }

            int carry = 0;
            ListNode head = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
                int sum = carry;
                sum += stack1.isEmpty() ? 0 : stack1.pop();
                sum += stack2.isEmpty() ? 0 : stack2.pop();
                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;
                carry = sum / 10;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}