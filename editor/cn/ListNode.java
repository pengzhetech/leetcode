/**
 * @author pengzhe
 * @date 2020/6/29 08:57
 * @description
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("array can not be null or empty");
        }
        this.val = numbers[0];
        ListNode cur = this;
        for (int i = 1; i < numbers.length; i++) {
            cur.next = new ListNode(numbers[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val).append("->");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
