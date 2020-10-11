//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
// Related Topics 设计 链表

public class DesignLinkedList_707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(0);
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        System.out.println(linkedList.size);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(linkedList.size));
        //linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.dummy.next);
        int i = linkedList.get(1);//返回2
        System.out.println(i);
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyLinkedList {
        //链表中元素的个数
        private int size;
        private ListNode dummy;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
            dummy = new ListNode(0);
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            //两种极端情况均需考虑,因为链表的索引是从0开始的,索引index=size时,角标已越界
            if (index >= size || index < 0) return -1;

            ListNode cur = dummy;
            //因为有一个dummy节点,所以index需要加1,才能到index节点
            for (int i = 0; i < index + 1; ++i) {
                cur = cur.next;
            }
            return cur.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {

            if (index > size) return;
            if (index < 0) index = 0;
            size++;
            //1:找到要插入节点的前驱节点
            ListNode prev = dummy;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            ListNode toAdd = new ListNode(val);

            toAdd.next = prev.next;
            prev.next = toAdd;

        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) return;
            size--;
            ListNode prev = dummy;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
//leetcode submit region end(Prohibit modification and deletion)


    class MyDoubleLinedList {
        int size;
        // sentinel nodes as pseudo-head and pseudo-tail
        ListNode head, tail;

        public MyDoubleLinedList() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            // if index is invalid
            if (index < 0 || index >= size) return -1;

            // choose the fastest way: to move from the head
            // or to move from the tail
            ListNode curr = head;
            if (index + 1 < size - index)
                for (int i = 0; i < index + 1; ++i) curr = curr.next;
            else {
                curr = tail;
                for (int i = 0; i < size - index; ++i) curr = curr.prev;
            }

            return curr.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode pred = head, succ = head.next;

            ++size;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = succ;
            pred.next = toAdd;
            succ.prev = toAdd;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode succ = tail, pred = tail.prev;

            ++size;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = succ;
            pred.next = toAdd;
            succ.prev = toAdd;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            // If index is greater than the length,
            // the node will not be inserted.
            if (index > size) return;

            // [so weird] If index is negative,
            // the node will be inserted at the head of the list.
            if (index < 0) index = 0;

            // find predecessor and successor of the node to be added
            ListNode pred, succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; ++i) pred = pred.next;
                succ = pred.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index; ++i) succ = succ.prev;
                pred = succ.prev;
            }

            // insertion itself
            ++size;
            ListNode toAdd = new ListNode(val);
            toAdd.prev = pred;
            toAdd.next = succ;
            pred.next = toAdd;
            succ.prev = toAdd;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            // if the index is invalid, do nothing
            if (index < 0 || index >= size) return;

            // find predecessor and successor of the node to be deleted
            ListNode pred, succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; ++i) pred = pred.next;
                succ = pred.next.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
                pred = succ.prev.prev;
            }

            // delete pred.next
            --size;
            pred.next = succ;
            succ.prev = pred;
        }

    }


}