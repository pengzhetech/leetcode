//由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 
//
// 如果我们可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。例如，根据定义，"abc" 可以从 “abdbec” 获得
//，但不能从 “acbbe” 获得。 
//
// 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长）和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤ 106。现在考虑字符串 S
//1 和 S2，其中 S1=[s1,n1] 、S2=[s2,n2] 。 
//
// 请你找出一个可以满足使[S2,M] 从 S1 获得的最大整数 M 。 
//
// 
//
// 示例： 
//
// 输入：
//s1 ="acb",n1 = 4
//s2 ="ab",n2 = 2
//
//返回：
//2
// 
// Related Topics 动态规划 
// 👍 126 👎 0

public class CountTheRepetitions_466 {
    public static void main(String[] args) {
        Solution solution = new CountTheRepetitions_466().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}