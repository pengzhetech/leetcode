//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1160 👎 0

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix_14().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String prefix = strs[0];
            for (String s : strs) {
                while (s.indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            return prefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}