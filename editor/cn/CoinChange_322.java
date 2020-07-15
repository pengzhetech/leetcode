//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 700 👎 0

public class CoinChange_322 {
    public static void main(String[] args) {
        Recursion solution = new CoinChange_322().new Recursion();
        int[] coins = {1, 2, 5, 10, 40};
        //System.out.println(solution.coinChange(coins, 79));

        Solution solution1 = new CoinChange_322().new Solution();
        int[] coinss = {1, 2, 5};
        System.out.println(solution1.coinChange(coinss, 11));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            if (coins.length == 0) {
                return -1;
            }

            findWay(coins, amount, 0);

            // 如果没有任何一种硬币组合能组成总金额，返回 -1。
            if (res == Integer.MAX_VALUE) {
                return -1;
            }
            return res;
        }

        public void findWay(int[] coins, int amount, int count) {
            if (amount < 0) {
                return;
            }
            if (amount == 0) {
                res = Math.min(res, count);
            }

            for (int i = 0; i < coins.length; i++) {
                findWay(coins, amount - coins[i], count + 1);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 递归解法
     */
    class Recursion {
        public int coinChange(int[] coins, int amount) {
            return coinChange(0, coins, amount);
        }

        private int coinChange(int idxCoin, int[] coins, int amount) {
            if (amount == 0)
                return 0;
            if (idxCoin < coins.length && amount > 0) {
                int maxVal = amount / coins[idxCoin];
                int minCost = Integer.MAX_VALUE;
                for (int x = 0; x <= maxVal; x++) {
                    if (amount >= x * coins[idxCoin]) {
                        int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                        if (res != -1)
                            minCost = Math.min(minCost, res + x);
                    }
                }
                return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
            }
            return -1;
        }
    }

    /**
     * 动态规划,自上而下
     */
    class UpToDownSolution {
        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min)
                    min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }

    }

}