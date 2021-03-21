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
        public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            if(num==null||num.length<3)return ans;

            Arrays.sort(num);

            int length=num.length;

            for(int i=0;i<length;i++){
                int curNum=num[i];
                if(curNum>=0)break;
                if(num[i]==num[i+1])continue;
                int left=i+1;
                int right=length-1;

                while(left<right){
                    int sum=curNum+num[left]+num[right];
                    if(sum==0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(curNum);
                        list.add(num[left]);
                        list.add(num[right]);
                        ans.add(list);
                        while(left<right&&num[left]==num[left+1]){
                            left++;
                        }
                        while(left<right&&num[right]==num[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<0){
                        left++;
                    }else {
                        right--;
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}