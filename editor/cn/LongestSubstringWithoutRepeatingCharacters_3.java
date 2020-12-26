//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters_3().new Solution();
        int i = solution.lengthOfLongestSubstring("12312423423423");
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            //存储字符,保证没有重复的出现
            Set<Character> set = new HashSet<>();

            int length = s.length();
            //右指针,开始位于字符串最左边
            int rk = -1;
            int ans = 0;

            //遍历整个字符串
            for (int i = 0; i < length; ++i) {
                //如果i不等于0,说明已经遇到一个重复的字符了,此时,滑动窗口
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                //右指针不断向右移
                while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                    ++rk;
                    set.add(s.charAt(rk + 1));
                }
                ans = Math.max(ans, rk - i + 1);
            }

            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}