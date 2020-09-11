//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，系统会告诉你，你猜测的数字比系统选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// -1 : 你猜测的数字比系统选出的数字大
// 1 : 你猜测的数字比系统选出的数字小
// 0 : 恭喜！你猜对了！
// 
//
// 
//
// 示例 : 
//
// 输入: n = 10, pick = 6
//输出: 6 
// Related Topics 二分查找 
// 👍 80 👎 0

public class GuessNumberHigherOrLower_374 {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower_374().new Solution();
        int i = solution.guessNumber(10);
        System.out.println(i);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Forward declaration of guess API.
     *
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                // int mid = left + (right - left + 1) / 2;
                int mid = (left + right + 1) >>> 1;
                int guessNum = guess(mid);
                if (guessNum == -1) {
                    // 中位数比猜的数大，因此比中位数大的数包括中位数都不是目标元素
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            // 最后剩下的数一定是所求，无需后处理
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class GuessGame {

        private static final int NUM = 6;

        int guess(int num) {
            if (num == NUM) {
                return 0;
            } else if (num < NUM) {
                return -1;
            }
            return 1;
        }
    }
}