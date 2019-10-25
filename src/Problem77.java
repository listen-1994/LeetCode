import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 第77题 组合
 * 递归问题
 */
public class Problem77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        core(result, 1, n, k);
        return result;
    }

    public void core(List<List<Integer>> result, int begin, int end, int k) {
        if (k > end - begin + 1 || k == 0) {
            return;
        }
        for (int i = begin; i <= end - k + 1; i++) {
            List<List<Integer>> subResult = new LinkedList<>();
            core(subResult, i + 1, end, k - 1);
            if(subResult.isEmpty()){
                List<Integer> thisResult = new LinkedList<>();
                thisResult.add(i);
                result.add(thisResult);
            }
            for (List<Integer> list : subResult) {
                List<Integer> thisResult = new LinkedList<>();
                thisResult.add(i);
                thisResult.addAll(list);
                result.add(thisResult);
            }
        }
    }

    public static void main(String[] args) {
        Problem77 problem77 = new Problem77();
        System.out.println(problem77.combine(4,2));
    }
}
