
/**
 * @author pengzhe
 * @date 2020/7/1 07:48
 * @description
 */

public class ListNodeTest {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        test(head);
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
