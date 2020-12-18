//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划 
// 👍 853 👎 0

import java.util.Stack;

public class LongestValidParentheses_32 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        int validParentheses = longestValidParentheses("()");
        System.out.println(validParentheses);

    }

    /**
     * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的左括号的下标」
     * ，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前左括号：
     *
     * 如果栈为空，说明当前的右括号为没有被匹配的左括号，
     * 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * 我们从前往后遍历字符串并更新答案即可。
     *
     * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，
     * 这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，
     * 我们在一开始的时候往栈中放入一个值为 -1−1 的元素
     *
     * @param s f
     * @return f
     */
    public static int longestValidParentheses(String s) {

        int longest = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;

    }

}