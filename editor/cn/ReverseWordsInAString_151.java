//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串 
// 👍 201 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString_151().new Solution();
    }

    /**
     * 由于双端队列支持从队列头部插入的方法，
     * 因此我们可以沿着字符串一个一个单词处理，
     * 然后将单词压入队列的头部，再将队列转成字符串即可。
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int left = 0, right = s.length() - 1;
            // 去掉字符串开头的空白字符
            while (left <= right && s.charAt(left) == ' ') ++left;

            // 去掉字符串末尾的空白字符
            while (left <= right && s.charAt(right) == ' ') --right;

            Deque<String> d = new ArrayDeque<>();
            StringBuilder word = new StringBuilder();

            while (left <= right) {
                char c = s.charAt(left);
                if ((word.length() != 0) && (c == ' ')) {
                    // 将单词 push 到队列的头部
                    d.offerFirst(word.toString());
                    word.setLength(0);
                } else if (c != ' ') {
                    word.append(c);
                }
                ++left;
            }
            d.offerFirst(word.toString());

            return String.join(" ", d);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}