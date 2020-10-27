//如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3
//, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入: [1,2,3,4,5,6,7,8]
//输出: 5
//解释:
//最长的斐波那契式子序列为：[1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 输入: [1,3,7,11,12,14,18]
//输出: 3
//解释:
//最长的斐波那契式子序列有：
//[1,11,12]，[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 1000 
// 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9 
// （对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%） 
// 
// Related Topics 数组 动态规划 
// 👍 129 👎 0

public class LengthOfLongestFibonacciSubsequence_873 {
    public static void main(String[] args) {
        Solution solution = new LengthOfLongestFibonacciSubsequence_873().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}