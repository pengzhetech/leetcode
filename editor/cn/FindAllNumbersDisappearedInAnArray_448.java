//给定一个范围在 1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。 
//
// 找到所有在 [1, n] 范围之间没有出现在数组中的数字。 
//
// 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。 
//
// 示例: 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[5,6]
// 
// Related Topics 数组 
// 👍 398 👎 0

import java.util.*;

public class FindAllNumbersDisappearedInAnArray_448 {
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray_448().new Solution();
        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(numbers);
        System.out.println(disappearedNumbers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            // Hash table for keeping track of the numbers in the array
            // Note that we can also use a set here since we are not
            // really concerned with the frequency of numbers.
            HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();

            // Add each of the numbers to the hash table
            for (int i = 0; i < nums.length; i++) {
                hashTable.put(nums[i], true);
            }

            // Response array that would contain the missing numbers
            List<Integer> result = new LinkedList<Integer>();

            // Iterate over the numbers from 1 to N and add all those
            // that don't appear in the hash table.
            for (int i = 1; i <= nums.length; i++) {
                if (!hashTable.containsKey(i)) {
                    result.add(i);
                }
            }

            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}