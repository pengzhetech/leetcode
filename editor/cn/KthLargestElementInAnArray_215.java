//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 613 👎 0

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray_215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    public class Solution {

        // 根据 k 的不同，选最大堆和最小堆，目的是让堆中的元素更小
        // 思路 1：k 要是更靠近 0 的话，此时 k 是一个较大的数，用最大堆
        // 例如在一个有 6 个元素的数组里找第 5 大的元素
        // 思路 2：k 要是更靠近 len 的话，用最小堆

        // 所以分界点就是 k = len - k

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            if (k <= len - k) {
                // System.out.println("使用最小堆");
                // 特例：k = 1，用容量为 k 的最小堆
                // 使用一个含有 k 个元素的最小堆
                PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
                for (int i = 0; i < k; i++) {
                    minHeap.add(nums[i]);
                }
                for (int i = k; i < len; i++) {
                    // 看一眼，不拿出，因为有可能没有必要替换
                    Integer topEle = minHeap.peek();
                    // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                    if (nums[i] > topEle) {
                        minHeap.poll();
                        minHeap.add(nums[i]);
                    }
                }
                return minHeap.peek();

            } else {
                // System.out.println("使用最大堆");
                assert k > len - k;
                // 特例：k = 100，用容量为 len - k + 1 的最大堆
                int capacity = len - k + 1;
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
                for (int i = 0; i < capacity; i++) {
                    maxHeap.add(nums[i]);
                }
                for (int i = capacity; i < len; i++) {
                    // 看一眼，不拿出，因为有可能没有必要替换
                    Integer topEle = maxHeap.peek();
                    // 只要当前遍历的元素比堆顶元素大，堆顶弹出，遍历的元素进去
                    if (nums[i] < topEle) {
                        maxHeap.poll();
                        maxHeap.add(nums[i]);
                    }
                }
                return maxHeap.peek();
            }
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num : nums) {
            minHeap.add(num);
        }

        for(int i=0;i<nums.length-k;i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }

}