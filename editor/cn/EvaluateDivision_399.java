//给出方程式 A / B = k, 其中 A 和 B 均为用字符串表示的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，
//则返回 -1.0。 
//
// 示例 : 
//给定 a / b = 2.0, b / c = 3.0 
//问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
//返回 [6.0, 0.5, -1.0, 1.0, -1.0 ] 
//
// 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<p
//air<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.siz
//e()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。 
//
// 基于上述例子，输入如下： 
//
// equations(方程式) = [ ["a", "b"], ["b", "c"] ],
//values(方程式结果) = [2.0, 3.0],
//queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] 
//]. 
// 
//
// 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。 
// Related Topics 并查集 图 
// 👍 182 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision_399 {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision_399().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * key : 当前节点
         * value : 其父节点
         */
        private Map<String, String> parents = new HashMap<>();
        /**
         * key : 当前节点
         * value : 父节点/当前节点
         */
        private Map<String, Double> values = new HashMap<>();

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            for (int i = 0; i < equations.size(); i++) {
                union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
            }
            double[] result = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String e = queries.get(i).get(0);
                String q = queries.get(i).get(1);
                if (!(parents.containsKey(e) && parents.containsKey(q))) {
                    result[i] = -1;
                    continue;
                }
                if (e.equals(q)) {
                    result[i] = 1;
                    continue;
                }
                String r1 = root(e);
                String r2 = root(q);
                if (!r1.equals(r2)) {
                    // 如果两者不相等，说明两个节点是不连通的
                    result[i] = -1;
                    continue;
                }
                result[i] = pm(q) / pm(e);
            }
            return result;
        }

        private void union(String parent, String child, double value) {
            add(parent);
            add(child);
            String r1 = root(parent);
            String r2 = root(child);
            if (!r1.equals(r2)) {
                parents.put(r2, r1);
                values.put(r2, value * (pm(parent) / pm(child)));
            }
        }

        private void add(String x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                values.put(x, 1.0);
            }
        }


        /**
         * 找到x的根节点
         */
        private String root(String x) {
            while (!parents.get(x).equals(x)) {
                x = parents.get(x);
            }
            return x;
        }


        /**
         * 循环的pm函数
         */
        private double pm(String x) {
            double v = 1;
            while (!parents.get(x).equals(x)) {
                v *= values.get(x);
                x = parents.get(x);
            }
            return v;
        }

//    /**
//     * 递归的pm函数
//     * @param x
//     * @return
//     */
//    private double pm(String x){
//        return parents.get(x).equals(x)?1:values.get(x)*pm(parents.get(x));
//    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}