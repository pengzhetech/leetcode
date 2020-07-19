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

        LongestPalindromicSubstring_5 palindromicSubstring5 = new LongestPalindromicSubstring_5();
        System.out.println(palindromicSubstring5.bruteForceLongestPalindrome("abb2wrwerwerwerwererrrrrrc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            return null;
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
        for (int i = 0; i < length - 1; i++) {//起始索引
            for (int j = i + 1; j < length; j++) {//结束索引
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