//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2378 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        Solution solution = new ThreeSum_15().new Solution();
        System.out.println(solution.threeSum(array));
    }

    /**
     * 双指针
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {//corner case
                return result;
            }
            Arrays.sort(nums);

            int length = nums.length;

            for (int firstPointer = 0; firstPointer < length; firstPointer++) {//first pointer
                if (firstPointer > 0 && nums[firstPointer] == nums[firstPointer - 1]) {
                    continue;
                }
                int target = -nums[firstPointer];
                int secondPointer = firstPointer + 1;
                int thirdPointer = length - 1;
                while (secondPointer < thirdPointer) {
                    if (nums[secondPointer] + nums[thirdPointer] == target) {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[firstPointer]);
                        res.add(nums[secondPointer]);
                        res.add(nums[thirdPointer]);
                        result.add(res);
                        secondPointer++;
                        thirdPointer--;
                        while (secondPointer < length && nums[secondPointer] == nums[secondPointer - 1]) {
                            secondPointer++;
                        }
                        while (thirdPointer > secondPointer && nums[thirdPointer] == nums[thirdPointer +1]) {
                            thirdPointer--;
                        }
                    } else if (nums[secondPointer] + nums[thirdPointer] > target) {
                        thirdPointer--;
                    } else {
                        secondPointer++;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}