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
    class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)

}