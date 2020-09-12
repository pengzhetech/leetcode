//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划 
// 👍 335 👎 0

public class SplitArrayLargestSum_410 {
    public static void main(String[] args) {
        Solution solution = new SplitArrayLargestSum_410().new Solution();

        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        int res = solution.splitArray(nums, m);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        public int splitArray(int[] nums, int m) {
            int max = 0;
            int sum = 0;

            // 计算「子数组各自的和的最大值」的上下界
            for (int num : nums) {
                max = Math.max(max, num);
                sum += num;
            }

            // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
            // 使得它对应的「子数组的分割数」恰好等于 m
            int left = max;
            int right = sum;
            while (left < right) {
                int mid = left + (right - left) / 2;

                int splits = split(nums, mid);
                if (splits > m) {
                    // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                    // 下一轮搜索的区间是 [mid + 1, right]
                    left = mid + 1;
                } else {
                    // 下一轮搜索的区间是上一轮的反面区间 [left, mid]
                    right = mid;
                }
            }
            return left;
        }

        /***
         *
         * @param nums 原始数组
         * @param maxIntervalSum 子数组各自的和的最大值
         * @return 满足不超过「子数组各自的和的最大值」的分割数
         */
        private int split(int[] nums, int maxIntervalSum) {
            // 至少是一个分割
            int splits = 1;
            // 当前区间的和
            int curIntervalSum = 0;
            for (int num : nums) {
                // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
                if (curIntervalSum + num > maxIntervalSum) {
                    curIntervalSum = 0;
                    splits++;
                }
                curIntervalSum += num;
            }
            return splits;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}