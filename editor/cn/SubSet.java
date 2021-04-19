import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author pengzhe
 * @date 2021/4/19 21:54
 * @description
 */

public class SubSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(subsets(arr));
    }

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (S.length == 0) {
            return res;
        }
        Arrays.sort(S);
        dfs(res, list, S, 0);
        return res;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> res,
                           ArrayList<Integer> list, int[] num, int start) {
        if (start > num.length) return;
        res.add(new ArrayList<>(list));
        for (int i = start; i < num.length; ++i) {
            list.add(num[i]);
            dfs(res, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
