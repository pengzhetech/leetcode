//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2425 👎 0

public class LongestPalindromicSubstring_5 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring_5().new Solution();

        String s = "abb2wrwerwerwerwererrrrrrc";

        LongestPalindromicSubstring_5 palindromicSubstring5 = new LongestPalindromicSubstring_5();
        System.out.println("暴力法------->" + palindromicSubstring5.bruteForceLongestPalindrome(s));
        System.out.println("动态规划------>" + solution.longestPalindrome(s));


    }

    /**
     * 动态规划解法
     * <p>
     * 在头尾字符相等的情况下，里面子串的回文性质据定了整个子串的回文性质【状态转移方程】
     *
     * <p>
     * 边界条件，即子串的长度为 1 或 2。对于长度为 1 的子串，它显然是个回文串；
     * 对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串
     * <p>
     * <p>
     * 在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的
     * ，因此一定要注意动态规划的循环顺序。
     *
     * @return
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            if (s == null || s.length() == 0) {
                return s;
            }

            int length = s.length();
            char[] charArray = s.toCharArray();

            //表示i,j是否是回文子串,闭区间i,j都能取到
            //字符串s[i j]s[i⋯j]是否为回文子串，如果是，dp[i][j] = true
            // dp[i][j]=true，如果不是，dp[i][j] = false
            boolean[][] isPalindrome = new boolean[length][length];

            int maxLength = 1;
            int beginIndex = 0;

            //枚举所有子串
            for (int j = 1; j < length; j++) {//表示子串的结束索引位置
                for (int i = 0; i < j; i++) {
                    if (charArray[i] != charArray[j]) {
                        isPalindrome[i][j] = false;//首尾不等,肯定不是回文子串
                    } else {
                        if (j - i < 3) {//在收尾相等的情况下,长度小于3的子串肯定是回文的
                            isPalindrome[i][j] = true;
                        } else {
                            //状态转移方程
                            isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                        }
                    }
                    if (isPalindrome[i][j] && j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        beginIndex = i;
                    }
                }
            }
            return s.substring(beginIndex, beginIndex + maxLength);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    private String bruteForceLongestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();

        //最大回文子串的长度
        int maxLongestPalindromeLength = 1;
        //最大回文子串的开始索引位置
        int maxLongestPalindromeBeginIndex = 0;

        char[] charArray = s.toCharArray();

        //穷举s所有的子串
        for (int j = 1; j < length; j++) {//起始索引
            for (int i = 0; i < j; i++) {//结束索引
                if (isPalindrome(charArray, i, j) && j - i + 1 > maxLongestPalindromeLength) {
                    maxLongestPalindromeBeginIndex = i;
                    maxLongestPalindromeLength = j - i + 1;
                }
            }
        }
        return s.substring(maxLongestPalindromeBeginIndex,
                maxLongestPalindromeBeginIndex + maxLongestPalindromeLength);
    }


    private boolean isPalindrome(char[] subStringArray, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            if (subStringArray[beginIndex] != subStringArray[endIndex]) {
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }
}