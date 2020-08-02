
/**
 * @author pengzhe
 * @date 2020/7/1 07:48
 * @description
 */

public class ListNodeTest {

    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);

        System.out.println(testList(listNode));

        // System.out.println(endOfFirstHalf(listNode));

       /* ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        test(head);*/
    }


    static ListNode testList(ListNode head) {

        System.out.println("输入的链表::" + head);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(100);


        System.out.println("新链表::" + dummy.next);

        return dummy.next;
    }


    private static ListNode endOfFirstHalf(ListNode head) {

        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void test(ListNode head) {

        System.out.println("原链表::" + head);
        /**
         * cur与head指向同一块内存地址,更改cur的内容即更改head的内容
         */
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == 2) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        System.out.println("cur::" + cur);
        System.out.println("原链表::" + head);
    }

}
