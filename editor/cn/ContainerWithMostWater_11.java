//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1637 👎 0


public class ContainerWithMostWater_11 {
    public static void main(String[] args) {

        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        Solution solution = new ContainerWithMostWater_11().new Solution();
        System.out.println(solution.maxArea(array));
        System.out.println(maxArea(array));
    }

    /**
     * 双指针
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {

            //左指针索引
            int left = 0;
            //右指针索引
            int right = height.length - 1;

            int maxArea = 0;

            while (left < right) {
                int length = right - left;
                int high = Math.min(height[left], height[right]);
                int area = length * high;
                maxArea = Math.max(area, maxArea);
                //左边矮,左指针向右移动
                if (height[left] <= height[right]) {
                    left++;
                } else {//右边矮,右指针向左移动
                    right--;
                }
            }
            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 暴力解法,穷举所有可能的面积
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int arrayLength = height.length;

        int maxArea = 0;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = arrayLength - 1; j > i && j < arrayLength; j--) {
                int high = Math.min(height[i], height[j]);
                int length = j - i;
                int area = high * length;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

}