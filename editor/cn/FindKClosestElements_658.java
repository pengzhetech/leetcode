//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一
//样，优先选择数值较小的那个数。 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5], k=4, x=3
//输出: [1,2,3,4]
// 
//
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4,5], k=4, x=-1
//输出: [1,2,3,4]
// 
//
// 
//
// 说明: 
//
// 
// k 的值为正数，且总是小于给定排序数组的长度。 
// 数组不为空，且长度不超过 104 
// 数组里的每个元素与 x 的绝对值不超过 104 
// 
//
// 
//
// 更新(2017/9/19): 
//这个参数 arr 已经被改变为一个整数数组（而不是整数列表）。 请重新加载代码定义以获取最新更改。 
// Related Topics 二分查找 
// 👍 140 👎 0

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements_658{
      public static void main(String[] args) {
           Solution solution = new FindKClosestElements_658().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      public class Solution {
          public List<Integer> findClosestElements(int[] arr, int k, int x) {
              List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
              int n = ret.size();
              if (x <= ret.get(0)) {
                  return ret.subList(0, k);
              } else if (ret.get(n - 1) <= x) {
                  return ret.subList(n - k, n);
              } else {
                  int index = Collections.binarySearch(ret, x);
                  if (index < 0)
                      index = -index - 1;
                  int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

                  while (high - low > k - 1) {
                      if ((x - ret.get(low)) <= (ret.get(high) - x))
                          high--;
                      else if ((x - ret.get(low)) > (ret.get(high) - x))
                          low++;
                      else
                          System.out.println("unhandled case: " + low + " " + high);
                  }
                  return ret.subList(low, high + 1);
              }
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }