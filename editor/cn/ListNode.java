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
