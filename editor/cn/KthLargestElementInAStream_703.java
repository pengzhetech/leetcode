//设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。 
//
// 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返
//回当前数据流中第K大的元素。 
//
// 示例: 
//
// 
//int k = 3;
//int[] arr = [4,5,8,2];
//KthLargest kthLargest = new KthLargest(3, arr);
//kthLargest.add(3);   // returns 4
//kthLargest.add(5);   // returns 5
//kthLargest.add(10);  // returns 5
//kthLargest.add(9);   // returns 8
//kthLargest.add(4);   // returns 8
// 
//
// 说明: 
//你可以假设 nums 的长度≥ k-1 且k ≥ 1。 
// Related Topics 堆 
// 👍 151 👎 0

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {
    public static void main(String[] args) {
        KthLargest solution = new KthLargestElementInAStream_703().new KthLargest(1, null);
        solution.add(1);
    }

    /**
     * 关于 Java 的 PriorityQueue 优先级队列
     * 1 是线程不安全的队列
     * 2 存储使用数组实现
     * 3 利用比较器做优先级比较
     * <p>
     * 实现说明
     * 1 最小堆的特性就是最小的值在最上面，每次取O(1)，插入O(logn)
     * 2 初始化的时候，注意如何添加元素，并给队列一个合适大小的初值
     * 3 每次添加元素，能添加到队列的有两种情况，一种未到k个，另一种比堆顶大
     * <p>
     * 实现代码
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    public class KthLargest {

        private PriorityQueue<Integer> queue;
        private int limit;

        public KthLargest(int k, int[] nums) {
            limit = k;
            queue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < limit) {
                queue.add(val);
            } else if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }

            return queue.peek();
        }

    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}