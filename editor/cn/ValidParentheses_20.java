//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses_20().new Solution();
        boolean valid = solution.isValid("124124");
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] wordList = s.toCharArray();
            char[] wordArray = new char[s.length()];
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (wordList[i] == '(' || wordList[i] == '[' || wordList[i] == '{') {
                    stack.push(wordList[i]);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    wordArray[cnt] = stack.peek();
                    cnt++;

                    stack.pop();
                    wordArray[cnt] = wordList[i];
                    cnt++;
                }
            }
            int correct = 0;
            for (int i = 0; i < wordArray.length - 1; i += 2) {
                if (wordArray[i] == '(' && wordArray[i + 1] == ')' || wordArray[i] == '[' && wordArray[i + 1] == ']' || wordArray[i] == '{' && wordArray[i + 1] == '}') {
                    correct += 2;
                }
            }

            return (correct == wordArray.length) ? true : false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}